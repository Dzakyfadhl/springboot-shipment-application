package com.lawencon.shipment.service;

import java.util.List;
import com.lawencon.shipment.dto.ShipmentRequestDTO;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ShipmentService {

  Shipments insertShipment(ShipmentRequestDTO request) throws Exception;

	List<Shipments> getAll() throws Exception;

    List<Shipments> getByCashierId(String id) throws Exception;

	Shipments findByShippingCode(String code) throws Exception;

	List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception;

}
