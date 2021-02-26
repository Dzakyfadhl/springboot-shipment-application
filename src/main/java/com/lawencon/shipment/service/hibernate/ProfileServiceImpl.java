package com.lawencon.shipment.service.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.shipment.dao.EmpProfileDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.ProfileService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	@Qualifier(value = "jpa_profile")
	private EmpProfileDao empProfileDao;

	@Override
	public List<EmployeeProfiles> getListProfile() throws Exception {
		return empProfileDao.getListProfile();
	}

	@Override
	public void insertProfile(EmployeeProfiles empProfile) throws Exception {
		empProfileDao.insertProfile(empProfile);
	};

	@Override
	public EmployeeProfiles getProfileByCode(String profileCode) throws Exception {
		return empProfileDao.getProfileByCode(profileCode);

	}

	@Override
	public EmployeeProfiles getProfileByUserId(EmployeeProfiles employeeProfiles) throws Exception {
		return empProfileDao.getProfileByUserId(employeeProfiles);

	}

	@Override
	public EmployeeProfiles updateData(EmployeeProfiles employeeProfiles) throws Exception {
		return empProfileDao.updateData(employeeProfiles);
	}

	@Override
	public List<EmployeeProfiles> getProfileCourier() throws Exception {
		return empProfileDao.getProfileCourier();
	}

	@Override
	@Transactional
	public EmployeeProfiles findByUsersId(Users user) throws Exception {
		return empProfileDao.findByUsersId(user);
	}
}
