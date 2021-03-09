package com.lawencon.shipment.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.CategoriesDao;
import com.lawencon.shipment.error.IllegalRequestException;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.repo.CategoriesRepo;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "jpa_category")
public class CategoriesDaoJpaImpl extends BaseDao implements CategoriesDao {

	@Autowired
	private CategoriesRepo categoriesRepo;

	@Override
	public List<Categories> getListCategories() throws Exception {
		return categoriesRepo.findAll();
	}

	@Override
	public void insertCategory(Categories category) throws Exception {
		categoriesRepo.save(category);
	}

	@Override
	public Categories getCategoryByCode(String categoryCode) throws Exception {
		return categoriesRepo.findByCategoriesCode(categoryCode);

	}

	@Override
	public Categories updateData(Categories category) throws Exception {
		return categoriesRepo.save(category);
	}

	@Override
    public void deleteData(String id) throws Exception {
      categoriesRepo.deleteById(id);
	}

    @Override
    public Categories findById(String id) throws Exception {
      return categoriesRepo.findById(id).orElseThrow(() -> new IllegalRequestException("id", id));
    }
}
