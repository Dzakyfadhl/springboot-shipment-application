package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.Senders;
import com.lawencon.shipment.service.SendersService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class SendersController {

  @Autowired
  private SendersService senderService;

  @GetMapping(value = "/senders")
  public ResponseEntity<WebResponse<List<Senders>>> getSenders() throws Exception {
    return WebResponseUtils.createWebResponse(senderService.getListSenders(), HttpStatus.OK);
  }

  @PostMapping(value = "/sender")
  public ResponseEntity<WebResponse<String>> insert(@RequestBody Senders body) throws Exception {
    senderService.insertSenders(body);
    return WebResponseUtils.createWebResponse("Sender data has been saved", HttpStatus.CREATED);
  }

  @PutMapping(value = "/sender")
  public ResponseEntity<WebResponse<String>> updateAll(@RequestBody Senders body) throws Exception {
    senderService.updateData(body);
    return WebResponseUtils.createWebResponse("Sender data has been updated", HttpStatus.OK);
        }
}
