package com.lawencon.shipment.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ShipmentsDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public class ShipmentsDaoHibernateImpl extends BaseDao implements ShipmentsDao {

	@Override
	public Shipments insertShipment(Shipments ship) throws Exception {
		em.persist(ship);
		return ship;
	}

	@Override
	public Shipments updateTotalPrice(Shipments ship) throws Exception {
		em.createQuery(bBuilder("UPDATE Shipments set totalPrice = ?1 + ?2 WHERE id = ?3 ").toString())
				.setParameter(1, ship.getTotalPrice()).setParameter(2, ship.getServiceId().getServicePrice())
				.setParameter(3, ship.getId()).executeUpdate();

		return ship;
	}

	@Override
	public List<Shipments> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipments updateData(Shipments ship) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipments> getByCashierId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipments findByShippingCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
