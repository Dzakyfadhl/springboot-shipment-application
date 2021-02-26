package com.lawencon.shipment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.model.Senders;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface SendersRepo extends JpaRepository<Senders, Long> {

	Senders findBySenderCode(String senderCode) throws Exception;

}
