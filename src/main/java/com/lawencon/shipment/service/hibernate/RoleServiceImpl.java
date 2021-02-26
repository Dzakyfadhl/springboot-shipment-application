package com.lawencon.shipment.service.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.shipment.dao.RolesDao;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.service.RoleService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier(value = "jpa_roles")
	private RolesDao rolesDao;

	@Override
	public List<Roles> getListRoles() throws Exception {
		return rolesDao.getListRoles();
	}

	@Override
	public void insertRoles(Roles roles) throws Exception {
		rolesDao.insertRoles(roles);
	}
}
