package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.service.CategoryService;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

    @GetMapping(value = "/categories")
    public ResponseEntity<WebResponse<List<Categories>>> getCategories() throws Exception {
      return WebResponseUtils.createWebResponse(categoryService.getListCategories(), HttpStatus.OK);
	}

    @PostMapping(value = "/category")
    public ResponseEntity<WebResponse<String>> insert(@RequestBody Categories request)
        throws Exception {
      categoryService.insertCategory(request);
      return WebResponseUtils.createWebResponse("Insert category success!", HttpStatus.CREATED);
	}

    @PutMapping(value = "/category")
    public ResponseEntity<WebResponse<String>> updateAll(@RequestBody Categories request)
        throws Exception {
      categoryService.updateData(request);
      return WebResponseUtils.createWebResponse("Update data category success!", HttpStatus.OK);
	}

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<WebResponse<String>> deleteById(@PathVariable("id") String id)
        throws Exception {
      categoryService.deleteData(id);
      return WebResponseUtils.createWebResponse("Delete data category success!", HttpStatus.OK);

	}

}
