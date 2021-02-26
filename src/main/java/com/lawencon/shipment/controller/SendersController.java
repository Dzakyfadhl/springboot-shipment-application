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
import com.lawencon.shipment.model.Senders;
import com.lawencon.shipment.service.SendersService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/sender")
public class SendersController {

	@Autowired
	private SendersService senderService;

	@GetMapping
	public Response<?> getSenders() {
		try {
			List<Senders> listResult = senderService.getListSenders();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PostMapping
	public Response<?> insert(@RequestBody String body) {
		try {
			Senders sender = new ObjectMapper().readValue(body, Senders.class);
			sender = senderService.insertSenders(sender);
			return new Response<>(HttpStatus.CREATED, sender);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PutMapping
	public Response<?> updateAll(@RequestBody String body) {
		try {
			Senders sender = new ObjectMapper().readValue(body, Senders.class);
			sender = senderService.updateData(sender);
			return new Response<>(HttpStatus.OK, sender);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}
}
