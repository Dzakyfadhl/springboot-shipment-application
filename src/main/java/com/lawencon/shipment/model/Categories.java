package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@Table(name = "tb_m_categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categories_code", unique = true, nullable = false, length = 100)
	private String categoriesCode;

	@Column(name = "categories_name", nullable = false, length = 100)
	private String categoriesName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}

	public String getCategoriesCode() {
		return categoriesCode;
	}

	public void setCategoriesCode(String categoriesCode) {
		this.categoriesCode = categoriesCode;
	}

}
