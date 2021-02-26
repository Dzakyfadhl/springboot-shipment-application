package com.lawencon.shipment.dao;

import java.util.List;

import com.lawencon.shipment.model.Senders;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface SendersDao {

	List<Senders> getListSenders() throws Exception;

	Senders insertSenders(Senders sender) throws Exception;

	void deleteSender(Senders sender) throws Exception;

	Senders getSenderByCode(Senders sender) throws Exception;

	Senders updateData(Senders sender) throws Exception;
}
