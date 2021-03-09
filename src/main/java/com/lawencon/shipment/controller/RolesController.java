package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.Roles;
import com.lawencon.shipment.service.RoleService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class RolesController {

	@Autowired
	private RoleService roleService;

    @GetMapping(value = "/roles")
    public ResponseEntity<WebResponse<List<Roles>>> getRoles() throws Exception {
      return WebResponseUtils.createWebResponse(roleService.getListRoles(), HttpStatus.OK);
	}

    @PostMapping(value = "/role")
    public ResponseEntity<WebResponse<String>> insert(@RequestBody Roles body) throws Exception {
      roleService.insertRoles(body);
      return WebResponseUtils.createWebResponse("New role created", HttpStatus.CREATED);
	}
}
