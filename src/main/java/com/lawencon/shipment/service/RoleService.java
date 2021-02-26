package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.Roles;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface RoleService {

	List<Roles> getListRoles() throws Exception;

	void insertRoles(Roles roles) throws Exception;

}
