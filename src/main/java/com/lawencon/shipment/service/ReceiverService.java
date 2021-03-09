package com.lawencon.shipment.service;

import java.util.List;
import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ReceiverService {

	Receivers insertReceiver(Receivers receiver) throws Exception;

    List<Receivers> getReceiverByCourier(String id) throws Exception;

	void updateReceiveStatus(Receivers receiver) throws Exception;

	Receivers updateData(Receivers receiver) throws Exception;

    List<Receivers> findByShipmentId(String shipId) throws Exception;

	List<Receivers> getByCourier(String empCode) throws Exception;
}
