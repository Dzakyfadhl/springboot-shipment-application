package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.service.ReceiverService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class ReceiversController {

  @Autowired
  private ReceiverService receiverService;

  @GetMapping(value = "/receivers/{CourierId}")
  public ResponseEntity<WebResponse<List<Receivers>>> getByCourier(
      @PathVariable("CourierId") String CourierId) throws Exception {
    return WebResponseUtils.createWebResponse(receiverService.getReceiverByCourier(CourierId),
        HttpStatus.OK);
  }

  @GetMapping(value = "/receivers/courier-code/{code}")
  public ResponseEntity<WebResponse<List<Receivers>>> getByCourierCode(
      @PathVariable("code") String code) throws Exception {
    return WebResponseUtils.createWebResponse(receiverService.getByCourier(code), HttpStatus.OK);
  }

  @GetMapping(value = "/receivers/ship-code/{id}")
  public ResponseEntity<WebResponse<List<Receivers>>> getByShipCode(
      @PathVariable("id") String id) throws Exception {
    return WebResponseUtils.createWebResponse(receiverService.findByShipmentId(id), HttpStatus.OK);
  }

  @PatchMapping(value = "/receiver")
  public ResponseEntity<WebResponse<String>> updateStatus(@RequestBody Receivers body)
      throws Exception {
    receiverService.updateReceiveStatus(body);
    return WebResponseUtils.createWebResponse("Update status success", HttpStatus.OK);
  }

  @PutMapping(value = "/receiver")
  public ResponseEntity<WebResponse<String>> updateData(@RequestBody Receivers body)
      throws Exception {
    receiverService.updateData(body);
    return WebResponseUtils.createWebResponse("Update data receiver success", HttpStatus.OK);
  }

}
