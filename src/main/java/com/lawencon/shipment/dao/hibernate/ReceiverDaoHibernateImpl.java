package com.lawencon.shipment.dao.hibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ReceiverDao;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class ReceiverDaoHibernateImpl extends BaseDao implements ReceiverDao {

	@Override
	public Long countData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receivers insertReceiver(Receivers receiver) throws Exception {
		em.persist(receiver);
		return receiver;
	}

	@Override
	public List<Receivers> getReceiverByCourier(Long id) throws Exception {
		List<Receivers> listReceiver = new ArrayList<>();
		List<Object[]> listObj = em
				.createQuery(
						bBuilder("select r.id, r.receiverCode, r.receiverName , r.receiverPhone ,r.receiverAddress, ",
								"r.arrivalTime , r.receiveStatus, s.shippingCode from Receivers r ",
								"inner join Shipments s where s.couriers_id = 2").toString(),
						Object[].class)
				.getResultList();
		listObj.forEach(objArr -> {
			Receivers receiver = new Receivers();
			receiver.setId(Long.valueOf(objArr[0].toString()));
			receiver.setReceiverCode((String) objArr[1]);
			receiver.setReceiverPhone((String) objArr[2]);
			receiver.setReceiverAddress((String) objArr[3]);
			receiver.setArrivalTime((LocalDateTime) objArr[4]);
			receiver.setReceiveStatus((String) objArr[5]);

			Shipments shipments = new Shipments();
			shipments.setShippingCode((String) objArr[6]);

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
		return null;
	}

	@Override
	public List<Receivers> findByShipmentId(Shipments shipments) throws Exception {
		return null;
	}

	@Override
	public List<Receivers> getByCourier(String empCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
