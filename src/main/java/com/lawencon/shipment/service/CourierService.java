package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface CourierService {

	List<Receivers> getReceiverByCourier() throws Exception;

	void updateReceiveStatus(Receivers receiver) throws Exception;
}
