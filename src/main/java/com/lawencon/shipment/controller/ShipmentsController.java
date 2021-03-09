package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.dto.ShipmentRequestDTO;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.service.ShipmentService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class ShipmentsController {

  @Autowired
  private ShipmentService shipmentService;

  @GetMapping(value = "/shipments")
  public ResponseEntity<WebResponse<List<Shipments>>> getAll() throws Exception {
    return WebResponseUtils.createWebResponse(shipmentService.getAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/shipments/courier/{id}")
  public ResponseEntity<WebResponse<List<Shipments>>> findByCourierId(@PathVariable("id") String id)
      throws Exception {
    EmployeeProfiles ep = new EmployeeProfiles();
    ep.setId(id);
    return WebResponseUtils.createWebResponse(shipmentService.findByCourierId(ep), HttpStatus.OK);
  }

  @GetMapping(value = "/shipments/cashier/{cashierId}")
  public ResponseEntity<WebResponse<List<Shipments>>> getByCourier(
      @PathVariable("cashierId") String cashierId) throws Exception {
    return WebResponseUtils.createWebResponse(shipmentService.getByCashierId(cashierId),
        HttpStatus.OK);
  }

  @PostMapping(value = "/shipment")
  public ResponseEntity<?> insert(@RequestBody ShipmentRequestDTO request) throws Exception {
    shipmentService.insertShipment(request);
    return WebResponseUtils.createWebResponse("Shipment created", HttpStatus.CREATED);
  }

}
