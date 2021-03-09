package com.lawencon.shipment.service.hibernate;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.CategoriesDao;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.service.CategoryService;
import com.lawencon.shipment.util.ValidationUtil;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  @Qualifier(value = "hibernate_category")
  private CategoriesDao categoriesDao;

  @Autowired
  private ValidationUtil validationUtil;

  @Override
  public List<Categories> getListCategories() throws Exception {
    return categoriesDao.getListCategories();
  }

  @Override
  public void insertCategory(Categories category) throws Exception {
    validationUtil.validate(category);
    category.setCreatedAt(LocalDateTime.now());
    categoriesDao.insertCategory(category);
  }

  @Override
  public Categories getCategoryByCode(String categoryCode) throws Exception {
    return categoriesDao.getCategoryByCode(categoryCode);
  }

  @Override
  public Categories updateData(Categories category) throws Exception {
    Categories categoryDB = categoriesDao.findById(category.getId());

    categoryDB.setCategoriesCode(category.getCategoriesCode());
    categoryDB.setCategoriesName(category.getCategoriesName());
    categoryDB.setUpdatedAt(LocalDateTime.now());
    categoryDB.setUpdatedBy(category.getUpdatedBy());

    return categoriesDao.updateData(categoryDB);
  }

  @Override
  public void deleteData(String id) throws Exception {
    validationUtil.validateUUID(id);
    Categories checkDb = categoriesDao.findById(id);
    categoriesDao.deleteData(checkDb.getId());
  }

  @Override
  public Categories findById(String id) throws Exception {
    validationUtil.validateUUID(id);
    return categoriesDao.findById(id);
  }
}
