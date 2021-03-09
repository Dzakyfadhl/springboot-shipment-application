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
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.service.ServeShipService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class ServiceShipmentsController {

	@Autowired
	private ServeShipService serveShipService;

    @GetMapping(value = "/shipment-services")
    public ResponseEntity<WebResponse<List<ServiceShipments>>> getServiceShips() throws Exception {
      return WebResponseUtils.createWebResponse(serveShipService.getListServiceShip(),
          HttpStatus.OK);
	}

    @PostMapping(value = "/shipment-service")
    public ResponseEntity<WebResponse<String>> insert(@RequestBody ServiceShipments body)
        throws Exception {
      serveShipService.insertServiceShipment(body);
      return WebResponseUtils.createWebResponse("Shipment service created", HttpStatus.CREATED);
	}

    @PutMapping(value = "/shipment-service")
    public ResponseEntity<WebResponse<String>> update(@RequestBody ServiceShipments body)
        throws Exception {
      serveShipService.updateData(body);
      return WebResponseUtils.createWebResponse("Shipment service updated", HttpStatus.OK);
	}

}
