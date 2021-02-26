package com.lawencon.shipment.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ServicesShipmentDao;
import com.lawencon.shipment.model.ServiceShipments;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class ServicesShipmentDaoHibernateImpl extends BaseDao implements ServicesShipmentDao {

	@Override
	public List<ServiceShipments> getListServiceShip() throws Exception {
		List<ServiceShipments> listResult = em.createQuery("from ServiceShipments", ServiceShipments.class)
				.getResultList();
		return listResult;

	}

	@Override
	public void insertServiceShipment(ServiceShipments serviceShipments) throws Exception {
		em.persist(serviceShipments);

	}

	@Override
	public ServiceShipments getServiceByCode(String serviceCode) throws Exception {
		List<ServiceShipments> listResult = em
				.createQuery("from ServiceShipments where serviceCode = ?1 ", ServiceShipments.class)
				.setParameter(1, serviceCode).getResultList();
		return getResultModel(listResult);

	}

	@Override
	public ServiceShipments updateData(ServiceShipments serviceShipments) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
