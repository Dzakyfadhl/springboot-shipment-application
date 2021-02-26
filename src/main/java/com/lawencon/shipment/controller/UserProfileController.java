package com.lawencon.shipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Helper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.service.UserProfileService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@PostMapping
	public Response<?> insert(@RequestBody String body) {

		try {
			Helper helper = new ObjectMapper().readValue(body, Helper.class);
			userProfileService.insertUserProfile(helper.users, helper.employeeProfiles);
			return new Response<>(HttpStatus.OK, "Insert data success!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

}
