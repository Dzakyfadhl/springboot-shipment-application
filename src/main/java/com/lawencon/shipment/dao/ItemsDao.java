package com.lawencon.shipment.dao;

import java.util.List;

import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ItemsDao {

	void insertItems(ItemDetails listItemDetails) throws Exception;

	ItemDetails updateData(ItemDetails listItemDetails) throws Exception;

	List<ItemDetails> findByReceiversId(Receivers rcv) throws Exception;
}
