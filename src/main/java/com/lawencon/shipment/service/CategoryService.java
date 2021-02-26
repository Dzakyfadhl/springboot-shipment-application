package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.Categories;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface CategoryService {

	List<Categories> getListCategories() throws Exception;

	void insertCategory(Categories category) throws Exception;

	Categories getCategoryByCode(String categoryCode) throws Exception;

	Categories updateData(Categories category) throws Exception;

	void deleteData(Categories category) throws Exception;
}
