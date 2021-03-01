package com.lawencon.shipment.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ItemsDao;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.repo.ItemDetailsRepo;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository(value = "jpa")
public class ItemsDaoJpaImpl extends BaseDao implements ItemsDao {

	@Autowired
	private ItemDetailsRepo itemDetailsRepo;

	@Override
	public void insertItems(ItemDetails itemDetails) throws Exception {
		itemDetailsRepo.save(itemDetails);
	}

	@Override
	public ItemDetails updateData(ItemDetails listItemDetails) throws Exception {
		ItemDetails listItemDetailsDb = itemDetailsRepo.findById(listItemDetails.getId()).get();

		// Can't update receiver id
        listItemDetails.setReceivers(listItemDetailsDb.getReceivers());
		return itemDetailsRepo.save(listItemDetails);
	}

	@Override
	public List<ItemDetails> findByReceiversId(Receivers rcv) throws Exception {
      return itemDetailsRepo.findByReceivers(rcv);
	}
}
