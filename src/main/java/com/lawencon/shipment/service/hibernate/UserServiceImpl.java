package com.lawencon.shipment.service.hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.UsersDao;
import com.lawencon.shipment.dto.UserCreateRequestDTO;
import com.lawencon.shipment.error.DataIsNotExistException;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.UserService;
import com.lawencon.shipment.util.TransactionNumberUtil;
import com.lawencon.shipment.util.ValidationUtil;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  @Qualifier(value = "jpa_users")
  private UsersDao usersDao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private ValidationUtil validationUtil;

  @Override
  public List<Users> getListUsers() throws Exception {
    return usersDao.getListUsers();
  }

  @Override
  public Users getUserByCode(String userCode) throws Exception {
    return Optional.ofNullable(usersDao.getUserByCode(userCode))
        .orElseThrow(() -> new DataIsNotExistException("code", userCode));
  }

  @Override
  public void insertUser(UserCreateRequestDTO request) throws Exception {
    validationUtil.validate(request);

    Users user = new Users();
    user.setUserCode(TransactionNumberUtil.generateUserCode());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setCreatedBy(request.getCreatedBy());
    user.setTestJson(request.getJson());

    Roles role = new Roles();
    role.setId(request.getRoleId());
    user.setRoles(role);

    usersDao.insertUser(user);

  }

  @Override
  public Users findByUsername(String username) throws Exception {
    return Optional.ofNullable(usersDao.findByUsername(username))
        .orElseThrow(() -> new DataIsNotExistException("username", username));
  }

  @Override
  public String getIdByUserCode(String userCode) throws Exception {
    return usersDao.getIdByUserCode(userCode);
  }

  @Override
  public void UpdateUser(Users newUser) throws Exception {
    Users userDb = usersDao.findById(newUser.getId());

    userDb.setUpdatedAt(LocalDateTime.now());
    userDb.setUpdatedBy("Dzaky Super Admin");

    if (!userDb.getUsername().equals(newUser.getUsername())) {
      userDb.setUsername(newUser.getUsername());
    }

    if (!userDb.getPassword().equals(newUser.getPassword())) {
      userDb.setPassword(passwordEncoder.encode(newUser.getPassword()));
    }

    usersDao.updateUser(userDb);


  }

  @Override
  public Users findById(String id) throws Exception {
    validationUtil.validateUUID(id);
    return usersDao.findById(id);
  }

}
