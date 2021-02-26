package com.lawencon.shipment.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.RolesDao;
import com.lawencon.shipment.model.Roles;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public class RolesDaoHibernateImpl extends BaseDao implements RolesDao {

	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = em.createQuery("from Roles", Roles.class).getResultList();
		return listResult;

	}

	@Override
	public void insertRoles(Roles roles) throws Exception {
		em.persist(roles);

	}

}
