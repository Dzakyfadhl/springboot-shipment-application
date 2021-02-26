package com.lawencon.shipment.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.SendersDao;
import com.lawencon.shipment.model.Senders;
import com.lawencon.shipment.repo.SendersRepo;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "jpa_senders")
public class SendersDaoJpaImpl extends BaseDao implements SendersDao {

	@Autowired
	private SendersRepo sendersRepo;

	@Override
	public List<Senders> getListSenders() throws Exception {
		return sendersRepo.findAll();
	}

	@Override
	public Senders insertSenders(Senders senders) throws Exception {
		return sendersRepo.save(senders);
	}

	@Override
	public void deleteSender(Senders sender) throws Exception {
		em.remove(sender);

	}

	@Override
	public Senders getSenderByCode(Senders sender) throws Exception {
		return sendersRepo.findBySenderCode(sender.getSenderCode());
	}

	@Override
	public Senders updateData(Senders sender) throws Exception {
		return sendersRepo.save(sender);
	}
}
