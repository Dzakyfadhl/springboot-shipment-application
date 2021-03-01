package com.lawencon.shipment.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ItemDetailsRepo extends JpaRepository<ItemDetails, String> {

  List<ItemDetails> findByReceivers(Receivers rcv) throws Exception;

}
