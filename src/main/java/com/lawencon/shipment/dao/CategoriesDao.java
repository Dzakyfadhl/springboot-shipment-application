package com.lawencon.shipment.dao;

import java.util.List;
import com.lawencon.shipment.model.Categories;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface CategoriesDao {

	List<Categories> getListCategories() throws Exception;

	void insertCategory(Categories category) throws Exception;

	Categories getCategoryByCode(String categoryCode) throws Exception;

	Categories updateData(Categories category) throws Exception;

    void deleteData(String id) throws Exception;
}
