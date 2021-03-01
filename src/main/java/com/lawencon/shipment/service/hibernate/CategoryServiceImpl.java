package com.lawencon.shipment.service.hibernate;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.CategoriesDao;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.service.CategoryService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier(value = "jpa_category")
	private CategoriesDao categoriesDao;

	@Override
	public List<Categories> getListCategories() throws Exception {
		return categoriesDao.getListCategories();
	}

	@Override
	public void insertCategory(Categories category) throws Exception {
		String categoryName = category.getCategoriesName();
		String categoryCode = "CAT" + categoryName.charAt(0) + categoryName.charAt(categoryName.length() - 1);
		category.setCategoriesCode(categoryCode.toUpperCase());
		categoriesDao.insertCategory(category);

	}

	@Override
	public Categories getCategoryByCode(String categoryCode) throws Exception {
		return categoriesDao.getCategoryByCode(categoryCode);
	}

	@Override
	public Categories updateData(Categories category) throws Exception {
		return categoriesDao.updateData(category);
	}

	@Override
    public void deleteData(String id) throws Exception {
      categoriesDao.deleteData(id);
	}
}
