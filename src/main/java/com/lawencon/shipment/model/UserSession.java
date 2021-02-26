package com.lawencon.shipment.model;

import org.springframework.stereotype.Component;

/**
 * @author Dzaky Fadhilla Guci
 */
@Component
public class UserSession {

	private EmployeeProfiles activeProfile;

	public EmployeeProfiles getActiveProfile() {
		return activeProfile;
	}

	public void setActiveProfile(EmployeeProfiles activeProfile) {
		this.activeProfile = activeProfile;
	}

}
