package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@Table(name = "tb_m_couriers")
public class Couriers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "plate_number", unique = true, nullable = false, length = 15)
	private String plateNumber;

	@OneToOne
	@JoinColumn(name = "profile_id", nullable = false, unique = true)
	private EmployeeProfiles profileId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public EmployeeProfiles getProfileId() {
		return profileId;
	}

	public void setProfileId(EmployeeProfiles profileId) {
		this.profileId = profileId;
	}

}
