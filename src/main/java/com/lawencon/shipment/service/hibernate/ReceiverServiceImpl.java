package com.lawencon.shipment.service.hibernate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.ReceiverDao;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Senders;
import com.lawencon.shipment.model.Shipments;
import com.lawencon.shipment.service.ReceiverService;
import com.lawencon.shipment.service.SendersService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
public class ReceiverServiceImpl implements ReceiverService {

	@Autowired
	@Qualifier(value = "jpa_receiver")
	private ReceiverDao receiverDao;

	@Autowired
	private SendersService sendersService;

	@Override
	public Receivers insertReceiver(Receivers receiver) throws Exception {
		validateInput(receiver);

        Senders senders = sendersService.getSenderByCode(receiver.getSenders());
		if (senders == null) {
			throw new IllegalArgumentException("Invalid foreign key senders on receiver! ");
		}
        receiver.setSenders(senders);
        receiver.setStatus("Received");
		StringBuilder code = new StringBuilder("RCV");

		Long count = receiverDao.countData();

		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String formattedDateTime = currentDateTime.format(formatter);
		code.append(formattedDateTime).append("0").append(count.toString());
        receiver.setCode(code.toString());
		return receiverDao.insertReceiver(receiver);
	}

	private void validateInput(Receivers receiver) throws Exception {
		StringBuilder vldMsg = new StringBuilder("Invalid input ");
		int msgLength = vldMsg.length();

		if (receiver.getId() != null) {
			vldMsg.append(", id receiver must not inputed ");
		}
        if (receiver.getCode() != null) {
			vldMsg.append(", receiver code auto generated ");
		}
        if (receiver.getAddress() == null) {
			vldMsg.append(", receiver address ");
		}
        if (receiver.getPhone() == null || receiver.getPhone().length() > 15) {
			vldMsg.append(", receiver phone ");
		}
        if (receiver.getName() == null) {
			vldMsg.append(", receiver name ");
		}
        if (receiver.getSenders() == null) {
			vldMsg.append(", sender id ");
		}

		if (vldMsg.length() > msgLength) {
			throw new IllegalArgumentException(vldMsg.toString());
		}
	}

	@Override
	@Transactional
    public List<Receivers> getReceiverByCourier(String id) throws Exception {
		return receiverDao.getReceiverByCourier(id);
	}

	@Override
	@Transactional
	public void updateReceiveStatus(Receivers receiver) throws Exception {
		receiver.setArrivalTime(LocalDateTime.now());
		receiverDao.updateReceiveStatus(receiver);

	}

	@Override
	@Transactional
	public Receivers updateData(Receivers receiver) throws Exception {
		return receiverDao.updateData(receiver);
	}

	@Override
	@Transactional
    public List<Receivers> findByShipmentId(String id) throws Exception {
      Shipments shipments = new Shipments();
      shipments.setId(id);
      return receiverDao.findByShipmentId(shipments);
	}

	@Override
	public List<Receivers> getByCourier(String empCode) throws Exception {
		return receiverDao.getByCourier(empCode);
	}
}
