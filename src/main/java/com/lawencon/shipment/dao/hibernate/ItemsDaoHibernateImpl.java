package com.lawencon.shipment.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.ItemsDao;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class ItemsDaoHibernateImpl extends BaseDao implements ItemsDao {

	@Override
	public void insertItems(ItemDetails itemDetails) throws Exception {
		em.persist(itemDetails);

	}

	@Override
	public ItemDetails updateData(ItemDetails listItemDetails) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDetails> findByReceiversId(Receivers rcv) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
