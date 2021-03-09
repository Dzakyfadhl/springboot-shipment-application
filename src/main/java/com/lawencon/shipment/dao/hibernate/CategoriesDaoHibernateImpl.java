package com.lawencon.shipment.dao.hibernate;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.CategoriesDao;
import com.lawencon.shipment.error.IllegalRequestException;
import com.lawencon.shipment.model.Categories;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository(value = "hibernate_category")
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
      em.persist(category);
      return category;
	}

	@Override
    public void deleteData(String id) throws Exception {
      String query = "DELETE FROM Categories WHERE id = :id";
      em.createQuery(query).setParameter("id", id).executeUpdate();
	}

    @Override
    public Categories findById(String id) throws Exception {
      return Optional.ofNullable(em.find(Categories.class, id))
          .orElseThrow(() -> new IllegalRequestException("id", id));
    }
}
