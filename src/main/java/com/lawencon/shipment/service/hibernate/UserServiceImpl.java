package com.lawencon.shipment.service.hibernate;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.UsersDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.UserSession;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.ProfileService;
import com.lawencon.shipment.service.UserService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UsersDao usersDao;
	private ProfileService profileService;
	private UserSession userSession;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(@Qualifier(value = "jpa_users") UsersDao usersDao, UserSession userSession,
			ProfileService profileService) {
		this.usersDao = usersDao;
		this.userSession = userSession;
		this.profileService = profileService;
	}

	@Override
	public List<Users> getListUsers() throws Exception {
		return usersDao.getListUsers();
	}

	@Override
	public Users getUserByCode(String userCode) throws Exception {
		return usersDao.getUserByCode(userCode);
	}

	@Override
	public void insertUser(Users user) throws Exception {
		Long count = usersDao.countData();
		user.setUserCode("USER0" + count);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
		usersDao.insertUser(user);

	}

	@Override
	public Users loginUsernamePassword(Users user) throws Exception {

		Users userAll = usersDao.loginUserByUsernamePassword(user);
		EmployeeProfiles activeProfile = new EmployeeProfiles();
        activeProfile.setUsers(userAll);
		activeProfile = profileService.getProfileByUserId(activeProfile);
		userSession.setActiveProfile(activeProfile);
        userAll.setPassword("hidden");
		return userAll;

	}

	@Override
	public Users findByUsername(String username) throws Exception {
		return usersDao.findByUsername(username);
	}

	@Override
    public String getIdByUserCode(String userCode) throws Exception {
		return usersDao.getIdByUserCode(userCode);
	}

}
