package com.lawencon.shipment.dao.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ReceiverDao;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.repo.ReceiversRepo;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository(value = "jpa_receiver")
public class ReceiverDaoJpaImpl extends BaseDao implements ReceiverDao {

  @Autowired
  private ReceiversRepo receiversRepo;

  @Override
  public Receivers insertReceiver(Receivers receiver) throws Exception {
    return receiversRepo.save(receiver);
  }

  @Override
  public List<Receivers> getReceiverByCourier(String id) throws Exception {
    List<Receivers> listReceiver = new ArrayList<>();
    List<Object[]> listObj = receiversRepo.getReceiverByCourier(id);
    listObj.forEach(objArr -> {
      Receivers receiver = new Receivers();
      receiver.setId((String) objArr[0]);
      receiver.setCode((String) objArr[1]);
      receiver.setName((String) objArr[2]);
      receiver.setPhone((String) objArr[3]);
      receiver.setAddress((String) objArr[4]);

      Timestamp inDate = (Timestamp) objArr[5];
      receiver.setArrivalTime((LocalDateTime) inDate.toLocalDateTime());

      receiver.setStatus((String) objArr[6]);

      Shipments shipments = new Shipments();
      shipments.setTrxNumber((String) objArr[7]);

      receiver.setShipments(shipments);

      listReceiver.add(receiver);
    });

    return listReceiver;

  }

  @Override
  public void updateReceiveStatus(Receivers receiver) throws Exception {

    em.createQuery(
        "UPDATE Receivers SET receiveStatus = 'Delivered' , arrivalTime = ?1 WHERE receiver_code = ?2")
        .setParameter(1, receiver.getArrivalTime()).setParameter(2, receiver.getCode())
        .executeUpdate();

  }

  @Override
  public Receivers updateData(Receivers receiver) throws Exception {
    Receivers receiverDb = receiversRepo.findById(receiver.getId()).get();
    receiver.setShipments(receiverDb.getShipments());
    receiver.setSenders(receiverDb.getSenders());
    return receiversRepo.save(receiver);
  }

  @Override
  public List<Receivers> findByShipmentId(Shipments shipments) throws Exception {
    return receiversRepo.findByShipments(shipments);
  }

  @Override
  public Long countData() throws Exception {
    return receiversRepo.count();
  }

  @Override
  public List<Receivers> getByCourier(String empCode) throws Exception {
    return receiversRepo.getByCourier(empCode);
  }

}
