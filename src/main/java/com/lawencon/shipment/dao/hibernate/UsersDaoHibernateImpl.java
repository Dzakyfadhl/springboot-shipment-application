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
						"u.rolesId.id as id_role from Users as u where username = ?1 and passwords = ?2").toString(),
						Object[].class)
				.setParameter(1, user.getUsername()).setParameter(2, user.getPasswords()).getResultList();

		List<Users> listResult = new ArrayList<Users>();
		listObj.forEach(objArr -> {
			Users users = new Users();
			users.setId(Long.valueOf(objArr[0].toString()));
			users.setUserCode((String) objArr[1]);

			Roles roles = new Roles();
			roles.setRoleCode((String) objArr[2]);
			roles.setRoleName((String) objArr[3]);
			roles.setId(Long.valueOf(objArr[4].toString()));

			users.setRolesId(roles);
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
	public Users updateData(Users user) throws Exception {
		return null;
	}

	@Override
	public Users findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getIdByUserCode(String userCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
