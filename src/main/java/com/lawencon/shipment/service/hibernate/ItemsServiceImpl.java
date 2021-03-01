package com.lawencon.shipment.service.hibernate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.ItemsDao;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.model.ItemDetails;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.service.CategoryService;
import com.lawencon.shipment.service.ItemsService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	@Qualifier(value = "jpa")
	private ItemsDao itemsDao;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void insertItems(ItemDetails itemDetails) throws Exception {
		validateInput(itemDetails);
        Categories category =
            categoryService.getCategoryByCode(itemDetails.getCategories().getCategoriesCode());
		if (category == null) {
			throw new IllegalArgumentException("Category on item not found!");
		}
        itemDetails.setCategories(category);
		itemsDao.insertItems(itemDetails);
	}

	private void validateInput(ItemDetails item) throws Exception {
		StringBuilder vldMsg = new StringBuilder("Invalid input ");
		int msgLength = vldMsg.length();

		if (item.getId() != null) {
			vldMsg.append(", id item must not inputed ");
		}
		if (item.getItemName() == null || item.getItemName().trim().equals("")) {
			vldMsg.append(", item name ");
		}
        if (item.getDescription() == null || item.getDescription().trim().equals("")) {
			vldMsg.append(", item description ");
		}
		if (item.getWeight() == null) {
			vldMsg.append(", item weight ");
		}
        if (item.getCategories() == null) {
			vldMsg.append(", item categories code ");
		}

		if (vldMsg.length() > msgLength) {
			throw new IllegalArgumentException(vldMsg.toString());
		}
	}

	@Override
	public ItemDetails updateData(ItemDetails listItemDetails) throws Exception {
		return itemsDao.updateData(listItemDetails);
	}

	@Override
	public List<ItemDetails> findByReceiversId(Receivers rcv) throws Exception {

		return itemsDao.findByReceiversId(rcv);
	}
}
