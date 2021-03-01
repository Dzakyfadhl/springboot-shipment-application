package com.lawencon.shipment.dao;

import java.util.List;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ShipmentsDao {

	Shipments insertShipment(Shipments ship) throws Exception;

	Shipments updateTotalPrice(Shipments ship) throws Exception;

	List<Shipments> getAll() throws Exception;

	Shipments updateData(Shipments ship) throws Exception;

    List<Shipments> getByCashierId(String id) throws Exception;

	Shipments findByShippingCode(String code) throws Exception;

	List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception;

}
