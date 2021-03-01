package com.lawencon.shipment.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.EmpProfileDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class EmpProfileDaoHibernateImpl extends BaseDao implements EmpProfileDao {

	@Override
	public List<EmployeeProfiles> getListProfile() throws Exception {
		List<EmployeeProfiles> listResult = em.createQuery("from EmployeeProfiles", EmployeeProfiles.class)
				.getResultList();
		return listResult;

	}

	@Override
	public void insertProfile(EmployeeProfiles empProfile) throws Exception {
		em.persist(empProfile);

	}

	@Override
	public EmployeeProfiles getProfileByCode(String profileCode) throws Exception {

		List<EmployeeProfiles> listResult = em
				.createQuery("from EmployeeProfiles where employee_code = ?1 ", EmployeeProfiles.class)
				.setParameter(1, profileCode).getResultList();

		return getResultModel(listResult);

	}

	@Override
	public EmployeeProfiles getProfileByUserId(EmployeeProfiles employeeProfiles) throws Exception {

		List<EmployeeProfiles> listResult = em
				.createQuery("from EmployeeProfiles where users_id = ?1 ", EmployeeProfiles.class)
            .setParameter(1, employeeProfiles.getUsers().getId()).getResultList();

		return getResultModel(listResult);

	}

	@Override
	public EmployeeProfiles updateData(EmployeeProfiles employeeProfiles) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeProfiles findByUsersId(Users user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeProfiles> getProfileCourier() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
