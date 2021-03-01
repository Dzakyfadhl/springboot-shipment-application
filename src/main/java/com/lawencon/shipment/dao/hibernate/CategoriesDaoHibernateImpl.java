package com.lawencon.shipment.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.CategoriesDao;
import com.lawencon.shipment.model.Categories;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public class CategoriesDaoHibernateImpl extends BaseDao implements CategoriesDao {

	@Override
	public List<Categories> getListCategories() throws Exception {
		List<Categories> listResult = em.createQuery("from Categories", Categories.class).getResultList();
		return listResult;

	}

	@Override
	public void insertCategory(Categories category) throws Exception {
		em.persist(category);

	}

	@Override
	public Categories getCategoryByCode(String categoryCode) throws Exception {

		List<Categories> listResult = em.createQuery("from Categories where categoriesCode = ?1 ", Categories.class)
				.setParameter(1, categoryCode).getResultList();

		return getResultModel(listResult);

	}

	@Override
	public Categories updateData(Categories category) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void deleteData(String id) throws Exception {
		// TODO Auto-generated method stub

	}
}
