package com.lawencon.shipment.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ServicesShipmentDao;
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.repo.ServiceShipRepo;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository(value = "jpa_servship")
public class ServicesShipmentDaoJpaImpl extends BaseDao implements ServicesShipmentDao {

	@Autowired
	private ServiceShipRepo serviceShipRepo;

	@Override
	public List<ServiceShipments> getListServiceShip() throws Exception {
		return serviceShipRepo.findAll();

	}

	@Override
	public void insertServiceShipment(ServiceShipments serviceShipments) throws Exception {
		serviceShipRepo.save(serviceShipments);
	}

	@Override
	public ServiceShipments getServiceByCode(String serviceCode) throws Exception {
		return serviceShipRepo.findByServiceCode(serviceCode);
	}

	@Override
	public ServiceShipments updateData(ServiceShipments serviceShipments) throws Exception {
		return serviceShipRepo.save(serviceShipments);
	}
}
