package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.service.ItemsService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/itemdetails")
public class ItemDetailsController {

	@Autowired
	private ItemsService itemsService;

	@GetMapping("/rcvid/{id}")
    public Response<?> findByReceiversId(@PathVariable("id") String id) {
		try {
			Receivers rcv = new Receivers();
			rcv.setId(id);
			List<ItemDetails> itemDetails = itemsService.findByReceiversId(rcv);
			return new Response<>(HttpStatus.OK, itemDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}

	}

	@PutMapping
	public Response<?> updateAll(@RequestBody String body) {
		try {
			ItemDetails itemDetails = new ObjectMapper().readValue(body, ItemDetails.class);
			itemDetails = itemsService.updateData(itemDetails);
			return new Response<>(HttpStatus.OK, itemDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}

	}

}
