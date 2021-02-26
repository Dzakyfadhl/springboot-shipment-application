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
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.UserService;

/**
 * @author Dzaky Fadhilla Guci
 */
@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public Response<List<Users>> getUsers() {
		try {
			List<Users> listResult = userService.getListUsers();
			return new Response<>(HttpStatus.OK, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping("code/{userCode}")
	public Response<Users> getUsersByCode(@PathVariable("userCode") String userCode) {
		try {
			Users user = userService.getUserByCode(userCode);
			return new Response<>(HttpStatus.OK, user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@GetMapping("username/{username}")
	public Response<Users> getByUsername(@PathVariable("username") String username) {
		try {
			Users user = userService.findByUsername(username);
			return new Response<>(HttpStatus.OK, user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

	@PostMapping
	public Response<Users> insert(@RequestBody String body) {
		Users user;
		try {
			user = new ObjectMapper().readValue(body, Users.class);
			userService.insertUser(user);
			return new Response<>(HttpStatus.OK, user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

}
