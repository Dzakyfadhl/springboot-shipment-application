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
@Table(name = "tb_m_senders")
public class Senders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "senders_code", unique = true, nullable = false, length = 50)
	private String senderCode;

	@Column(name = "fullname", nullable = false, length = 50)
	private String fullName;

	@Column(nullable = false, length = 15)
	private String phone;

	@Column(name = "street_name", nullable = false, length = 100)
	private String streetName;

	public Senders() {

	}

	public Senders(String fullName, String phone, String streetName) {
		this.fullName = fullName;
		this.phone = phone;
		this.streetName = streetName;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getSenderCode() {
		return senderCode;
	}

	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

}
