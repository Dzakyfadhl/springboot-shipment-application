package com.lawencon.shipment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.helper.Response;
import com.lawencon.shipment.model.Categories;
import com.lawencon.shipment.service.CategoryService;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

    @GetMapping(value = "/categories")
	public Response<?> getCategories() {
		try {
			List<Categories> listCategory = categoryService.getListCategories();
			return new Response<>(HttpStatus.OK, listCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

    @PostMapping(value = "/category")
	public Response<?> insert(@RequestBody String body) {
		try {
			Categories category = new ObjectMapper().readValue(body, Categories.class);
			categoryService.insertCategory(category);
			return new Response<>(HttpStatus.CREATED, category);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

    @PutMapping(value = "/category")
	public Response<?> updateAll(@RequestBody String body) {
		try {
			Categories category = new ObjectMapper().readValue(body, Categories.class);
			category = categoryService.updateData(category);
			return new Response<>(HttpStatus.CREATED, category);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND, null);
		}
	}

    @DeleteMapping(value = "/category/{id}")
    public Response<?> deleteAll(@RequestBody String id) {
		try {
          categoryService.deleteData(id);
			return new Response<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.NOT_FOUND);
		}
	}

}
