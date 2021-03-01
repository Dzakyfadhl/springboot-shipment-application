package com.lawencon.shipment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.Categories;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, String> {

	Categories findByCategoriesCode(String categoriesCode) throws Exception;

}
