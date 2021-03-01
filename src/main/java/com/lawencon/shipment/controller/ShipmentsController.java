package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lawencon.shipment.helper.Helper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.service.ShipmentService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/shipment")
public class ShipmentsController {

	private ShipmentService shipmentService;

	@Autowired
	public ShipmentsController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}

	@GetMapping
	public Response<?> getAll() {
		List<Shipments> listResult;
		try {
			listResult = shipmentService.getAll();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<Shipments>(HttpStatus.NOT_FOUND, "data null");
		}
	}

	@GetMapping("/courid/{id}")
    public Response<?> findByCourierId(@PathVariable("id") String id) {
		EmployeeProfiles ep = new EmployeeProfiles();
		ep.setId(id);
		List<Shipments> listResult;
		try {
			listResult = shipmentService.findByCourierId(ep);
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<Shipments>(HttpStatus.NOT_FOUND, "data null");
		}
	}

	@GetMapping("/{cashierId}")
	public Response<?> getByCourier(@PathVariable("cashierId") String cashierId) {
		List<Shipments> listResult;
		try {
          listResult = shipmentService.getByCashierId(cashierId);
			return new Response<>(HttpStatus.OK, listResult);

		} catch (Exception e) {
			e.printStackTrace();
			return new Response<Shipments>(HttpStatus.NOT_FOUND, "data null");
		}
	}

	@PostMapping
	public Response<?> insert(@RequestBody String body) {
		try {
			ObjectMapper obj = new ObjectMapper();
			obj.registerModule(new JavaTimeModule());
			Helper helper = obj.readValue(body, Helper.class);
			Shipments shipments = shipmentService.insertShipment(helper.shipments, helper.listReceivers);
			return new Response<Shipments>(HttpStatus.OK, shipments);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("Foreign key")) {
				return new Response<>(HttpStatus.BAD_REQUEST, e.getMessage());
			} else if (e.getMessage().contains("Invalid input")) {
				return new Response<>(HttpStatus.BAD_REQUEST, e.getMessage());
			} else {
				return new Response<>(HttpStatus.BAD_REQUEST, "insert data failed");
			}
		}
	}

}
