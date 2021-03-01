package com.lawencon.shipment.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ShipmentsDao;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.repo.ShipmentsRepo;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "jpa_shipments")
public class ShipmentsDaoJpaImpl extends BaseDao implements ShipmentsDao {

	@Autowired
	private ShipmentsRepo shipmentsRepo;

	@Override
	public Shipments insertShipment(Shipments ship) throws Exception {
		return shipmentsRepo.save(ship);
	}

	@Override
	public Shipments updateTotalPrice(Shipments ship) throws Exception {
      shipmentsRepo.updateTotalPrice(ship.getTotalPrice(), ship.getService().getServicePrice(),
          ship.getId());
		return ship;
	}

	@Override
	public List<Shipments> getAll() throws Exception {
		return shipmentsRepo.findAllOrderByTrancastionTime();
	}

	@Override
	public Shipments updateData(Shipments ship) throws Exception {
		return shipmentsRepo.save(ship);
	}

	@Override
    public List<Shipments> getByCashierId(String id) throws Exception {
      return shipmentsRepo.getByCashier(id);
	}

	@Override
	public Shipments findByShippingCode(String code) throws Exception {
      return shipmentsRepo.findByTrxNumber(code);
	}

	@Override
	public List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception {
      return shipmentsRepo.findByCourier(courier);
	}
}
