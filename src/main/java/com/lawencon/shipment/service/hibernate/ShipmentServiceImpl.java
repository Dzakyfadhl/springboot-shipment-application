package com.lawencon.shipment.service.hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.ShipmentsDao;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.ServiceShipments;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.model.UserSession;
import com.lawencon.shipment.service.BranchService;
import com.lawencon.shipment.service.ItemsService;
import com.lawencon.shipment.service.ProfileService;
import com.lawencon.shipment.service.ReceiverService;
import com.lawencon.shipment.service.ServeShipService;
import com.lawencon.shipment.service.ShipmentService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

  private ShipmentsDao shipmentDao;

  private UserSession userSession;

  private ItemsService itemService;
  private ReceiverService receiverService;
  private BranchService branchService;
  private ServeShipService serveShipService;
  private ProfileService profileService;

  @Autowired
  public ShipmentServiceImpl(@Qualifier(value = "jpa_shipments") ShipmentsDao shipmentDao,
      ItemsService itemService, UserSession userSession, ReceiverService receiverService,
      BranchService branchService, ServeShipService serveShipService,
      ProfileService profileService) {
    this.shipmentDao = shipmentDao;
    this.itemService = itemService;
    this.userSession = userSession;
    this.receiverService = receiverService;
    this.branchService = branchService;
    this.serveShipService = serveShipService;
    this.profileService = profileService;
  }

  @Override
  public Shipments insertShipment(Shipments ship, List<Receivers> listReceivers) throws Exception {

    validateInput(ship);

    BranchRegions br = branchService.getBranchByCode(ship.getBranch().getBranchCode());
    ServiceShipments ss = serveShipService.getServiceByCode(ship.getService().getServiceCode());
    EmployeeProfiles courier = profileService.getProfileByCode(ship.getCourier().getEmployeeCode());
    EmployeeProfiles cashier = profileService.getProfileByCode(ship.getCashier().getEmployeeCode());

    validateFK(br, ss, courier, cashier);

    ship.setBranch(br);
    ship.setService(ss);
    ship.setCashier(cashier);
    ship.setCourier(courier);

    StringBuilder code = new StringBuilder("SHIP");

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy-HHmmss");
    String formattedDateTime = currentDateTime.format(formatter);
    ship.setTrxTime(currentDateTime);
    code.append(formattedDateTime);
    ship.setTrxNumber(code.toString());
    // ship.setCashierId(userSession.getActiveProfile());

    double tempPrice = 0;

    Shipments shipId = shipmentDao.insertShipment(ship);
    for (Receivers r : listReceivers) {
      r.setShipments(shipId);
      Receivers receiverId = receiverService.insertReceiver(r);
      for (ItemDetails i : r.getListItemsReceiver()) {
        i.setReceivers(receiverId);
        itemService.insertItems(i);
        tempPrice += (i.getWeight() * 5000);
      }

    }

    shipId.setTotalPrice(new BigDecimal(tempPrice));

    return shipmentDao.updateTotalPrice(shipId);

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
    if (listShipments.isEmpty()) {
      return null;
    } else {
      return shipmentDao.getByCashierId(id);
    }

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
