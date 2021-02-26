package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Table(name = "tb_m_users")
@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "passwords" })
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_code", unique = true, nullable = false, length = 100)
	private String userCode;

	@Column(unique = true, nullable = false, length = 20)
	private String username;

	@Column(nullable = false, length = 100)
	private String passwords;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "roles_id", nullable = false)
	private Roles rolesId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public Roles getRolesId() {
		return rolesId;
	}

	public void setRolesId(Roles rolesId) {
		this.rolesId = rolesId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
