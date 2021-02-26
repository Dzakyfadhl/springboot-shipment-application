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
	public List<Receivers> getReceiverByCourier(Long id) throws Exception {
		List<Receivers> listReceiver = new ArrayList<>();
		List<Object[]> listObj = receiversRepo.getReceiverByCourierId(id);

//		List<Object[]> listObj = em
//				.createQuery(
//						bBuilder("select r.id, r.receiverCode, r.receiverName , r.receiverPhone ,r.receiverAddress, ",
//								"r.arrivalTime , r.receiveStatus, s.shippingCode from Receivers r ",
//								"inner join Shipments s where s.couriers_id = 2").toString(),
//						Object[].class)
//				.getResultList();
		listObj.forEach(objArr -> {
			Receivers receiver = new Receivers();
			receiver.setId(Long.valueOf(objArr[0].toString()));
			receiver.setReceiverCode((String) objArr[1]);
			receiver.setReceiverName((String) objArr[2]);
			receiver.setReceiverPhone((String) objArr[3]);
			receiver.setReceiverAddress((String) objArr[4]);

			Timestamp inDate = (Timestamp) objArr[5];
			receiver.setArrivalTime((LocalDateTime) inDate.toLocalDateTime());

			receiver.setReceiveStatus((String) objArr[6]);

			Shipments shipments = new Shipments();
			shipments.setShippingCode((String) objArr[7]);

			receiver.setShipmentId(shipments);

			listReceiver.add(receiver);
		});

		return listReceiver;

	}

	@Override
	public void updateReceiveStatus(Receivers receiver) throws Exception {

		em.createQuery("UPDATE Receivers SET receiveStatus = 'Delivered' , arrivalTime = ?1 WHERE receiver_code = ?2")
				.setParameter(1, receiver.getArrivalTime()).setParameter(2, receiver.getReceiverCode()).executeUpdate();

	}

	@Override
	public Receivers updateData(Receivers receiver) throws Exception {
		Receivers receiverDb = receiversRepo.findById(receiver.getId()).get();
		receiver.setShipmentId(receiverDb.getShipmentId());
		receiver.setSenderId(receiverDb.getSenderId());
		return receiversRepo.save(receiver);
	}

	@Override
	public List<Receivers> findByShipmentId(Shipments shipments) throws Exception {
		return receiversRepo.findByShipmentId(shipments);
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
