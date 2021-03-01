package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.ProfileService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/profile")
public class EmployeeProfilesController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/all")
	public Response<?> getAll() {
		try {
			List<EmployeeProfiles> listResult = profileService.getListProfile();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping("/cashier/{id}")
    public Response<?> getCashier(@PathVariable("id") String id) {
		try {
			Users user = new Users();
			user.setId(id);
			EmployeeProfiles cashierProfile = profileService.findByUsersId(user);
			return new Response<>(HttpStatus.OK, cashierProfile);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping("/code/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			EmployeeProfiles courier = profileService.getProfileByCode(code);
			return new Response<>(HttpStatus.OK, courier);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping("/couriers")
	public Response<?> getAllCouriers() {
		try {
			List<EmployeeProfiles> listResult = profileService.getProfileCourier();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PostMapping
	public Response<?> insert(@RequestBody String body) {
		try {
			EmployeeProfiles employeeProfiles = new ObjectMapper().readValue(body, EmployeeProfiles.class);
			profileService.insertProfile(employeeProfiles);
			return new Response<>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public Response<?> updateAll(@RequestBody String body) {
		try {
			EmployeeProfiles employeeProfiles = new ObjectMapper().readValue(body, EmployeeProfiles.class);
			employeeProfiles = profileService.updateData(employeeProfiles);
			return new Response<>(HttpStatus.OK, employeeProfiles);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

}
