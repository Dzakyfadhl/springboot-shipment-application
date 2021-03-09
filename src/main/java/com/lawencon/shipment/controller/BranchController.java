package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.service.BranchService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class BranchController {

  @Autowired
  private BranchService branchService;

  @GetMapping(value = "/branchs")
  public ResponseEntity<WebResponse<List<BranchRegions>>> getBranch() throws Exception {
    return WebResponseUtils.createWebResponse(branchService.getListBranch(), HttpStatus.OK);
  }

  @PostMapping(value = "/branch")
  public ResponseEntity<WebResponse<String>> insert(@RequestBody BranchRegions request)
      throws Exception {
    branchService.insertBranch(request);
    return WebResponseUtils.createWebResponse("Insert branch success!", HttpStatus.CREATED);
  }

  @PutMapping(value = "/branch")
  public ResponseEntity<WebResponse<String>> update(@RequestBody BranchRegions request)
      throws Exception {
    branchService.updateData(request);
    return WebResponseUtils.createWebResponse("Update branch region success!", HttpStatus.OK);
  }

  @DeleteMapping(value = "/branch/{id}")
  public ResponseEntity<WebResponse<String>> deleteById(@PathVariable String id) throws Exception {
    branchService.deleteData(id);
    return WebResponseUtils.createWebResponse("Delete branch success!", HttpStatus.OK);
  }

}
