package com.lawencon.shipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.service.RoleService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<?> getRoles() {
		try {
			List<Roles> listResult = roleService.getListRoles();
			return new ResponseEntity<>(listResult, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Get roles failed", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody String body) {
		try {
			Roles roles = new ObjectMapper().readValue(body, Roles.class);
			roleService.insertRoles(roles);
			return new ResponseEntity<>("Insert data roles success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Insert data roles failed", HttpStatus.NOT_FOUND);
		}
	}
}
