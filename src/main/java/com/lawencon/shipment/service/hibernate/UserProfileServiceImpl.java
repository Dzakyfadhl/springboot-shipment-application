package com.lawencon.shipment.service.hibernate;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.ProfileService;
import com.lawencon.shipment.service.UserProfileService;
import com.lawencon.shipment.service.UserService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;

	@Override
	public void insertUserProfile(Users users, EmployeeProfiles employeeProfiles) throws Exception {
      // userService.insertUser(users);

        String id = userService.getIdByUserCode(users.getUserCode());
		users.setId(id);
        employeeProfiles.setUsers(users);
		profileService.insertProfile(employeeProfiles);
	}

}
