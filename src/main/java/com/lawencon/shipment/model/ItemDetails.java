package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Table(name = "tb_dtl_items")
public class ItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "items_name", nullable = false, length = 50)
	private String itemName;

	@Column(name = "items_description", nullable = false, length = 100)
	private String itemDesc;

	@Column(nullable = false)
	private Double weight;

	@ManyToOne
	@JoinColumn(name = "receiver_id", nullable = false)
	private Receivers receiversId;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Categories categoriesId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Receivers getReceiversId() {
		return receiversId;
	}

	public void setReceiversId(Receivers receiversId) {
		this.receiversId = receiversId;
	}

	public Categories getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(Categories categoriesId) {
		this.categoriesId = categoriesId;
	}

}
