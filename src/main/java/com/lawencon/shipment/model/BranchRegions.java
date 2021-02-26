package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "tb_m_branch_regions")
public class BranchRegions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "branch_code", unique = true, nullable = false, length = 100)
	private String branchCode;

	@Column(nullable = false, length = 100)
	private String region;

	@Column(unique = true, nullable = false, length = 15)
	private String phone;

	@Column(name = "street_name", nullable = false)
	private String streetName;

	public BranchRegions() {

	}

	public BranchRegions(String region, String phone, String streetName) {
		this.region = region;
		this.phone = phone;
		this.streetName = streetName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

}
