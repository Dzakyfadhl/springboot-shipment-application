package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ProfileService {

	List<EmployeeProfiles> getListProfile() throws Exception;

	void insertProfile(EmployeeProfiles empProfile) throws Exception;

	EmployeeProfiles getProfileByCode(String profileCode) throws Exception;

	EmployeeProfiles getProfileByUserId(EmployeeProfiles employeeProfiles) throws Exception;

	EmployeeProfiles updateData(EmployeeProfiles employeeProfiles) throws Exception;

	List<EmployeeProfiles> getProfileCourier() throws Exception;

	EmployeeProfiles findByUsersId(Users user) throws Exception;

}
