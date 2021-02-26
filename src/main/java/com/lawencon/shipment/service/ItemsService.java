package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface ItemsService {

	void insertItems(ItemDetails itemDetails) throws Exception;

	ItemDetails updateData(ItemDetails listItemDetails) throws Exception;

	List<ItemDetails> findByReceiversId(Receivers rcv) throws Exception;

}
