package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.service.BranchService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class BranchController {

  @Autowired
  private BranchService branchService;

  @GetMapping(value = "/branchs")
  public Response<List<BranchRegions>> getBranch() {
    try {
      List<BranchRegions> listBranch = branchService.getListBranch();
      return new Response<>(HttpStatus.OK, listBranch);
    } catch (Exception e) {
      e.printStackTrace();
      return new Response<>(HttpStatus.NOT_FOUND, null);
    }
  }

  @PostMapping(value = "/branch")
  public Response<BranchRegions> insert(@RequestBody String body) {
    try {
      BranchRegions branchRegions = new ObjectMapper().readValue(body, BranchRegions.class);
      branchService.insertBranch(branchRegions);
      return new Response<>(HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new Response<>(HttpStatus.NOT_FOUND);
    }

  }

  @PutMapping(value = "/branch")
  public Response<BranchRegions> updateAll(@RequestBody String body) {
    try {
      BranchRegions branchRegions = new ObjectMapper().readValue(body, BranchRegions.class);
      branchRegions = branchService.updateData(branchRegions);
      return new Response<>(HttpStatus.OK, branchRegions);
    } catch (Exception e) {
      e.printStackTrace();
      return new Response<>(HttpStatus.NOT_FOUND, null);
    }

  }

  @DeleteMapping(value = "/branch/{id}")
  public Response<BranchRegions> deleteAll(@PathVariable String id) {
    try {
      branchService.deleteData(id);
      return new Response<>(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new Response<>(HttpStatus.NOT_FOUND);
    }

  }

}
