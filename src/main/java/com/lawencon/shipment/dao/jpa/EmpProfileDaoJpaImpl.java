package com.lawencon.shipment.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.EmpProfileDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.repo.ProfilesRepo;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "jpa_profile")
public class EmpProfileDaoJpaImpl extends BaseDao implements EmpProfileDao {

	@Autowired
	private ProfilesRepo profilesRepo;

	@Override
	public List<EmployeeProfiles> getListProfile() throws Exception {
		return profilesRepo.findAll();
	}

	@Override
	public void insertProfile(EmployeeProfiles empProfile) throws Exception {
		profilesRepo.save(empProfile);
	}

	@Override
	public EmployeeProfiles getProfileByCode(String profileCode) throws Exception {
		return profilesRepo.findByEmployeeCode(profileCode);
	}

	@Override
	public EmployeeProfiles getProfileByUserId(EmployeeProfiles employeeProfiles) throws Exception {
      return profilesRepo.findByUsers(employeeProfiles.getUsers());
	}

	@Override
	public EmployeeProfiles updateData(EmployeeProfiles employeeProfiles) throws Exception {
		EmployeeProfiles employeeProfilesDb = profilesRepo.findById(employeeProfiles.getId()).get();
        employeeProfiles.setUsers(employeeProfilesDb.getUsers());
		return profilesRepo.save(employeeProfiles);
	}

	@Override
	public List<EmployeeProfiles> getProfileCourier() throws Exception {
		List<Object[]> listObj = profilesRepo.getProfileCourier();

		List<EmployeeProfiles> listCouriers = new ArrayList<EmployeeProfiles>();

		listObj.forEach(objArr -> {
			EmployeeProfiles ep = new EmployeeProfiles();
			ep.setEmployeeCode((String) objArr[0]);
			ep.setFullName((String) objArr[1]);
			listCouriers.add(ep);

		});

		return listCouriers;
	}

	@Override
	public EmployeeProfiles findByUsersId(Users user) throws Exception {
      return profilesRepo.findByUsers(user);
	}
}
