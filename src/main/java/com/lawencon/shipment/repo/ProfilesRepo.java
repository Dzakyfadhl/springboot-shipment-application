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
public interface ProfilesRepo extends JpaRepository<EmployeeProfiles, String> {

	EmployeeProfiles findByEmployeeCode(String employeeCode) throws Exception;

    EmployeeProfiles findByUsers(Users users) throws Exception;

    @Query(
        value = "SELECT e.employeeCode, e.fullName FROM EmployeeProfiles e INNER JOIN e.users u where u.roles.code = 'courier' ")
	List<Object[]> getProfileCourier() throws Exception;

}
