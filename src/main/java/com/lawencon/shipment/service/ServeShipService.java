package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.ServiceShipments;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ServeShipService {

	List<ServiceShipments> getListServiceShip() throws Exception;

	void insertServiceShipment(ServiceShipments serviceShipments) throws Exception;

	ServiceShipments getServiceByCode(String serviceCode) throws Exception;

	ServiceShipments updateData(ServiceShipments serviceShipments) throws Exception;

}
