package com.lawencon.shipment.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.UsersDao;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.repo.UsersRepo;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository(value = "jpa_users")
public class UsersDaoJpaImpl extends BaseDao implements UsersDao {

	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<Users> getListUsers() throws Exception {
		return usersRepo.findAll();
	}

	@Override
	public Users getUserByCode(String userCode) throws Exception {
		return usersRepo.findByUserCode(userCode);
	}

	@Override
	public Users loginUserByUsernamePassword(Users user) throws Exception {

		List<Object[]> listObj = usersRepo.login(user.getUsername(), user.getPasswords());

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
		usersRepo.save(user);
	}

	@Override
	public Users updateData(Users user) throws Exception {
		Users userDb = usersRepo.findById(user.getId()).get();
		user.setUsername(userDb.getUsername());
		return usersRepo.save(user);

	}

	@Override
	public Users findByUsername(String username) throws Exception {
		return usersRepo.findByUsername(username);
	}

	@Override
	public Long countData() throws Exception {
		return usersRepo.count();
	}

	@Override
	public Long getIdByUserCode(String userCode) throws Exception {
		return usersRepo.getIdByUserCode(userCode);
	}
}
