package com.lawencon.shipment.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.SendersDao;
import com.lawencon.shipment.model.Senders;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public class SendersDaoHibernateImpl extends BaseDao implements SendersDao {

	@Override
	public List<Senders> getListSenders() throws Exception {
		List<Senders> listResult = em.createQuery("from Senders", Senders.class).getResultList();
		return listResult;
	}

	@Override
	public Senders insertSenders(Senders senders) throws Exception {
		em.persist(senders);
		return senders;
	}

	@Override
	public void deleteSender(Senders sender) throws Exception {
		em.remove(sender);

	}

	@Override
	public Senders getSenderByCode(Senders sender) throws Exception {

		List<Senders> senders = em.createQuery("from Senders where senderCode = ?1 ", Senders.class)
				.setParameter(1, sender.getSenderCode()).getResultList();

		return getResultModel(senders);
//		return senders.size() > 0 ? senders.get(0) : null;
	}

	@Override
	public Senders updateData(Senders sender) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
