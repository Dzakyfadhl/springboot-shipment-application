package com.lawencon.shipment.service.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.shipment.dao.ServicesShipmentDao;
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.service.ServeShipService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class ServeShipServiceImpl implements ServeShipService {

	@Autowired
	@Qualifier(value = "jpa_servship")
	private ServicesShipmentDao servicesShipmentDao;

	@Override
	public List<ServiceShipments> getListServiceShip() throws Exception {
		return servicesShipmentDao.getListServiceShip();
	}

	@Override
	public void insertServiceShipment(ServiceShipments serviceShipments) throws Exception {
//		String serviceName = serviceShipments.getServiceName();
//		String categoryCode = "SRV" + serviceName.charAt(0) + serviceName.charAt(serviceName.length() - 1);
//		serviceShipments.setServiceCode(categoryCode.toUpperCase());
		servicesShipmentDao.insertServiceShipment(serviceShipments);

	}

	@Override
	public ServiceShipments getServiceByCode(String serviceCode) throws Exception {
		return servicesShipmentDao.getServiceByCode(serviceCode);

	}

	@Override
	public ServiceShipments updateData(ServiceShipments serviceShipments) throws Exception {
		return servicesShipmentDao.updateData(serviceShipments);
	}

}
