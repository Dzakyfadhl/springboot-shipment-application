package com.lawencon.shipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.service.ServeShipService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/serveshipment")
public class ServiceShipmentsController {

	@Autowired
	private ServeShipService serveShipService;

	@GetMapping
	public Response<?> getServiceShips() {
		try {
			List<ServiceShipments> listResult = serveShipService.getListServiceShip();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PostMapping
	public Response<?> insert(@RequestBody String body) {
		try {
			ServiceShipments serviceShipments = new ObjectMapper().readValue(body, ServiceShipments.class);
			serveShipService.insertServiceShipment(serviceShipments);
			return new Response<>(HttpStatus.CREATED, serviceShipments);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PutMapping
	public Response<?> updateAll(@RequestBody String body) {
		try {
			ServiceShipments serviceShipments = new ObjectMapper().readValue(body, ServiceShipments.class);
			serviceShipments = serveShipService.updateData(serviceShipments);
			return new Response<>(HttpStatus.OK, serviceShipments);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

}
