package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Dzaky Fadhilla Guci
 */

//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "usersId" })
@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "tb_m_employee_profiles")
public class EmployeeProfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employee_code", unique = true, nullable = false, length = 100)
	private String employeeCode;

	@Column(name = "fullname", nullable = false, length = 100)
	private String fullName;

	@Column(unique = true, nullable = false, length = 15)
	private String phone;

	@Column(name = "street_name", nullable = false, length = 100)
	private String streetName;

	@OneToOne
	@JoinColumn(name = "users_id", nullable = false)
	private Users usersId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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

	public Users getUsersId() {
		return usersId;
	}

	public void setUsersId(Users usersId) {
		this.usersId = usersId;
	}

}
