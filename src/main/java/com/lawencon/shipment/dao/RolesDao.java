package com.lawencon.shipment.dao;

import java.util.List;

import com.lawencon.shipment.model.Roles;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface RolesDao {

	List<Roles> getListRoles() throws Exception;

	void insertRoles(Roles roles) throws Exception;
}
