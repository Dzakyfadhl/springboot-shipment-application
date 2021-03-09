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
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.ProfileService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class EmployeeProfilesController {

	@Autowired
	private ProfileService profileService;

    @GetMapping(value = "/profiles")
    public ResponseEntity<WebResponse<List<EmployeeProfiles>>> getAll() throws Exception {
      return WebResponseUtils.createWebResponse(profileService.getListProfile(), HttpStatus.OK);
	}

    @GetMapping(value = "/profile/cashier/{id}")
    public ResponseEntity<WebResponse<EmployeeProfiles>> getCashier(@PathVariable("id") String id)
        throws Exception {
      Users user = new Users();
      user.setId(id);
      return WebResponseUtils.createWebResponse(profileService.findByUsersId(user), HttpStatus.OK);
	}

    @GetMapping(value = "/profile/code/{code}")
    public ResponseEntity<WebResponse<EmployeeProfiles>> getByCode(
        @PathVariable("code") String code) throws Exception {
      return WebResponseUtils.createWebResponse(profileService.getProfileByCode(code),
          HttpStatus.OK);
	}

    @GetMapping(value = "/profile/couriers")
    public ResponseEntity<WebResponse<List<EmployeeProfiles>>> getAllCouriers() throws Exception {
      return WebResponseUtils.createWebResponse(profileService.getProfileCourier(), HttpStatus.OK);
	}

    @PostMapping(value = "/profile")
    public ResponseEntity<WebResponse<String>> insert(@RequestBody EmployeeProfiles body)
        throws Exception {
      profileService.insertProfile(body);
      return WebResponseUtils.createWebResponse("Create profile success!", HttpStatus.OK);
	}

    @PutMapping(value = "/profile")
    public ResponseEntity<WebResponse<String>> update(@RequestBody EmployeeProfiles body)
        throws Exception {
      profileService.updateData(body);
      return WebResponseUtils.createWebResponse("Update data profile success", HttpStatus.OK);
	}

}
