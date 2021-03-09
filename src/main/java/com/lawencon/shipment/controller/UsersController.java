package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.dto.UserCreateRequestDTO;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.UserService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class UsersController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/users")
  public ResponseEntity<WebResponse<List<Users>>> getUsers() throws Exception {
    return WebResponseUtils.createWebResponse(userService.getListUsers(), HttpStatus.OK);
  }

  @GetMapping(value = "/user/{id}")
  public ResponseEntity<WebResponse<Users>> getUserById(@PathVariable String id) throws Exception {
    return WebResponseUtils.createWebResponse(userService.findById(id), HttpStatus.OK);
  }

  @GetMapping(value = "/user/code", params = "code")
  public ResponseEntity<WebResponse<Users>> getUsersByCode(String code) throws Exception {
    return WebResponseUtils.createWebResponse(userService.getUserByCode(code), HttpStatus.OK);
  }

  @GetMapping(value = "/user/username", params = "username")
  public ResponseEntity<WebResponse<Users>> getByUsername(String username) throws Exception {
    return WebResponseUtils.createWebResponse(userService.findByUsername(username), HttpStatus.OK);
  }

  @PutMapping(value = "/user")
  public ResponseEntity<WebResponse<String>> updateUser(@RequestBody Users newUser)
      throws Exception {
    userService.UpdateUser(newUser);
    return WebResponseUtils.createWebResponse("Update data user success!", HttpStatus.OK);
  }

  @PostMapping(value = "/user")
  public ResponseEntity<WebResponse<String>> insert(@RequestBody UserCreateRequestDTO user)
      throws Exception {
    userService.insertUser(user);
    return WebResponseUtils.createWebResponse("Create user success!", HttpStatus.CREATED);
  }

}
