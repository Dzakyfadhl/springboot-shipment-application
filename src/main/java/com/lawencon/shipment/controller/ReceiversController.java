package com.lawencon.shipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.service.ReceiverService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/receiver")
public class ReceiversController {

	@Autowired
	private ReceiverService receiverService;

	@GetMapping("{CourierId}")
	public Response<?> getByCourier(@PathVariable("CourierId") String CourierId) {
		try {
			List<Receivers> listResult = receiverService.getReceiverByCourier(Long.valueOf(CourierId));

			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.OK, null);
		}

	}

	@GetMapping("/courcode/{code}")
	public Response<?> getByCourierCode(@PathVariable("code") String code) {
		try {
			List<Receivers> listResult = receiverService.getByCourier(code);
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.OK, null);
		}

	}

	@GetMapping("/shipcode/{shipCode}")
	public Response<?> getByShipCode(@PathVariable("shipCode") Long id) {
		try {
			Shipments ship = new Shipments();
			ship.setId(id);
			List<Receivers> listResult = receiverService.findByShipmentId(ship);

			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.OK, null);
		}

	}

	@PatchMapping
	public Response<?> updateStatus(@RequestBody String body) {
		try {
			ObjectMapper obj = new ObjectMapper();
			obj.registerModule(new JavaTimeModule());
			Receivers receivers = obj.readValue(body, Receivers.class);
			receiverService.updateReceiveStatus(receivers);
			return new Response<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public Response<?> updateAll(@RequestBody String body) {
		try {
			Receivers receivers = new ObjectMapper().readValue(body, Receivers.class);
			receivers = receiverService.updateData(receivers);
			return new Response<>(HttpStatus.OK, receivers);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

}
