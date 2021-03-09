package com.lawencon.shipment.service.hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.ShipmentsDao;
import com.lawencon.shipment.dto.ShipmentRequestDTO;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.service.ItemsService;
import com.lawencon.shipment.service.ReceiverService;
import com.lawencon.shipment.service.ShipmentService;
import com.lawencon.shipment.util.TransactionNumberUtil;
import com.lawencon.shipment.util.ValidationUtil;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

  @Autowired
  @Qualifier(value = "jpa_shipments")
  private ShipmentsDao shipmentDao;

  @Autowired
  private ItemsService itemService;

  @Autowired
  private ReceiverService receiverService;

  @Autowired
  private ValidationUtil validationUtil;


  @Override
  public Shipments insertShipment(ShipmentRequestDTO request) throws Exception {
    validationUtil.validate(request);

    BranchRegions branch = new BranchRegions();
    branch.setId(request.getBracnhId());
    ServiceShipments service = new ServiceShipments();
    service.setId(request.getServiceId());
    EmployeeProfiles cashier = new EmployeeProfiles();
    cashier.setId(request.getCashierId());
    EmployeeProfiles courier = new EmployeeProfiles();
    courier.setId(request.getCourierId());

    // validateFK(br, ss, courier, cashier);

    Shipments shipments = new Shipments();

    shipments.setBranch(branch);
    shipments.setService(service);
    shipments.setCashier(cashier);
    shipments.setCourier(courier);
    shipments.setTrxTime(LocalDateTime.now());
    shipments.setTrxNumber(TransactionNumberUtil.generateShipNumber());

    double tempPrice = 0;

    shipmentDao.insertShipment(shipments);
    for (Receivers r : request.getListReceivers()) {
      r.setShipments(shipments);
      Receivers receiverId = receiverService.insertReceiver(r);
      for (ItemDetails i : r.getListItemsReceiver()) {
        i.setReceivers(receiverId);
        itemService.insertItems(i);
        tempPrice += (i.getWeight() * 5000);
      }

    }

    shipments.setTotalPrice(new BigDecimal(tempPrice));

    return shipmentDao.updateTotalPrice(shipments);

  }

  private void validateInput(Shipments ship) throws Exception {
    StringBuilder vldMsg = new StringBuilder("Invalid input ");
    int msgLength = vldMsg.length();

    if (ship.getId() != null) {
      vldMsg.append(", id ");
    }
    if (ship.getTrxNumber() != null) {
      vldMsg.append(", code auto generated ");
    }
    if (ship.getBranch() == null) {
      vldMsg.append(", branch ");
    }
    if (ship.getCashier() == null) {
      vldMsg.append(", cashier ");
    }
    if (ship.getCourier() == null) {
      vldMsg.append(", courier ");
    }
    if (ship.getService() == null) {
      vldMsg.append(", service ");
    }

    if (vldMsg.length() > msgLength) {
      throw new Exception(vldMsg.toString());
    }
  }

  private void validateFK(BranchRegions br, ServiceShipments ss, EmployeeProfiles courier,
      EmployeeProfiles cashier) throws Exception {
    StringBuilder vldMsg = new StringBuilder("Foreign key not found ");
    int msgLength = vldMsg.length();

    if (br == null) {
      vldMsg.append(", branch ");
    }
    if (ss == null) {
      vldMsg.append(", service ");
    }

    if (courier == null) {
      vldMsg.append(", courier ");
    }
    if (cashier == null) {
      vldMsg.append(", cashier ");
    }

    if (vldMsg.length() > msgLength) {
      throw new Exception(vldMsg.toString());
    }
  }

  @Override
  public List<Shipments> getAll() throws Exception {
    return shipmentDao.getAll();
  }

  @Override
  public List<Shipments> getByCashierId(String id) throws Exception {
    List<Shipments> listShipments = shipmentDao.getByCashierId(id);
    return listShipments;
  }

  @Override
  public Shipments findByShippingCode(String code) throws Exception {
    return shipmentDao.findByShippingCode(code);
  }

  @Override
  public List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception {
    return shipmentDao.findByCourierId(courier);
  }
}
