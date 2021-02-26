package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ReceiverService {

	Receivers insertReceiver(Receivers receiver) throws Exception;

	List<Receivers> getReceiverByCourier(Long id) throws Exception;

	void updateReceiveStatus(Receivers receiver) throws Exception;

	Receivers updateData(Receivers receiver) throws Exception;

	List<Receivers> findByShipmentId(Shipments ship) throws Exception;

	List<Receivers> getByCourier(String empCode) throws Exception;
}
