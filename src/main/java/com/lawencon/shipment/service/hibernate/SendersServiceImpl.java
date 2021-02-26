package com.lawencon.shipment.service.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.shipment.dao.SendersDao;
import com.lawencon.shipment.model.Senders;
import com.lawencon.shipment.service.SendersService;

/**
 * @author Dzaky Fadhilla Guci
 */
@Service
@Transactional
public class SendersServiceImpl implements SendersService {

	@Autowired
	@Qualifier(value = "jpa_senders")
	private SendersDao sendersDao;

	@Override
	public List<Senders> getListSenders() throws Exception {
		return sendersDao.getListSenders();
	}

	@Override
	public Senders insertSenders(Senders sender) throws Exception {
		String senderCode = sender.getFullName().substring(0, 4) + sender.getPhone().substring(9);
		sender.setSenderCode(senderCode.toUpperCase());
		return sendersDao.insertSenders(sender);
	}

	@Override
	public void deleteSender(Senders sender) throws Exception {

	}

	@Override
	public Senders getSenderByCode(Senders sender) throws Exception {
		return sendersDao.getSenderByCode(sender);
	}

	@Override
	public Senders updateData(Senders sender) throws Exception {
		return sendersDao.updateData(sender);
	}
}
