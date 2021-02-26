package com.lawencon.shipment.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.RolesDao;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.repo.RolesRepo;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "jpa_roles")
public class RolesDaoJpaImpl extends BaseDao implements RolesDao {

	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public List<Roles> getListRoles() throws Exception {
		return rolesRepo.findAll();
	}

	@Override
	public void insertRoles(Roles roles) throws Exception {
		rolesRepo.save(roles);
	}

}
