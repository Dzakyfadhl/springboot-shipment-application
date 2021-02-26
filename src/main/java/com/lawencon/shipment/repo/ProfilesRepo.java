package com.lawencon.shipment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ProfilesRepo extends JpaRepository<EmployeeProfiles, Long> {

	EmployeeProfiles findByEmployeeCode(String employeeCode) throws Exception;

	EmployeeProfiles findByUsersId(Users users) throws Exception;

	@Query(value = "SELECT e.employeeCode, e.fullName FROM EmployeeProfiles e INNER JOIN e.usersId u where u.rolesId.roleCode = 'courier' ")
	List<Object[]> getProfileCourier() throws Exception;

}
