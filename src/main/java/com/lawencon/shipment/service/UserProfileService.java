package com.lawencon.shipment.service;

import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface UserProfileService {

	void insertUserProfile(Users users, EmployeeProfiles employeeProfiles) throws Exception;

}
