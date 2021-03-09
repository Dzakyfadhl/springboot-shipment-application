package com.lawencon.shipment.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.UsersDao;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class UsersDaoHibernateImpl extends BaseDao implements UsersDao {

  @Override
  public List<Users> getListUsers() throws Exception {
    List<Users> listResult = em.createQuery("from Users", Users.class).getResultList();
    return listResult;

  }

  @Override
  public Users getUserByCode(String userCode) throws Exception {
    List<Users> listResult = em.createQuery("from Users where userCode = ?1 ", Users.class)
        .setParameter(1, userCode).getResultList();
    return getResultModel(listResult);

  }

  @Override
  public Users loginUserByUsernamePassword(Users user) throws Exception {
    List<Object[]> listObj = em
        .createQuery(bBuilder("select u.id, u.userCode , u.rolesId.roleCode, u.rolesId.roleName, ",
            "u.rolesId.id as id_role from Users as u where username = ?1 and passwords = ?2")
                .toString(),
            Object[].class)
        .setParameter(1, user.getUsername()).setParameter(2, user.getPassword()).getResultList();

    List<Users> listResult = new ArrayList<Users>();
    listObj.forEach(objArr -> {
      Users users = new Users();
      users.setId((String) objArr[0]);
      users.setUserCode((String) objArr[1]);

      Roles roles = new Roles();
      roles.setCode((String) objArr[2]);
      roles.setName((String) objArr[3]);
      roles.setId((String) objArr[4]);

      users.setRoles(roles);
      users.setUsername(user.getUsername());
      listResult.add(users);
    });
    return getResultModel(listResult);

  }

  @Override
  public void insertUser(Users user) throws Exception {
    em.persist(user);
  }

  @Override
  public Users findByUsername(String username) throws Exception {
    String query = "FROM Users WHERE username = ?";
    List<Users> users = em.createQuery(query, Users.class).getResultList();
    return getResultModel(users);
  }

  @Override
  public Long countData() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getIdByUserCode(String userCode) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateUser(Users user) throws Exception {
    em.persist(user);
  }

  @Override
  public Users findById(String id) throws Exception {
    return em.find(Users.class, id);
  }
}
