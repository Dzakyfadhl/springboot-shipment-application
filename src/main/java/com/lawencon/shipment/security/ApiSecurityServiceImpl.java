package com.lawencon.shipment.security;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.UserService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
public class ApiSecurityServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userDb;
		try {
			userDb = userService.findByUsername(username);
			if (userDb != null) {
              return new User(userDb.getUsername(), userDb.getPassword(), new ArrayList<>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
