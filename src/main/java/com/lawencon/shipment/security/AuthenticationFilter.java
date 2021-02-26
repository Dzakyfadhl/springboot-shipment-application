package com.lawencon.shipment.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.shipment.model.Users;
import com.lawencon.shipment.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * @author Dzaky Fadhilla Guci
 */

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private UserService userService;

	public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		super.setFilterProcessesUrl("/api/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Users user = new Users();
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPasswords()));

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String username = authResult.getName();
		Users user = new Users();

		try {
			user = this.userService.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String secretKey = "fsdjfnsdfqfnqinbwibv21312412768wvwivnqviq23141JFbsdafbuhdwadho";
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

		String token = Jwts.builder().signWith(key).setSubject(authResult.getName())
				.setExpiration(
						Date.from(LocalDateTime.now().plusMinutes(100).atZone(ZoneId.systemDefault()).toInstant()))
				.compact();

		response.setContentType("application/json");
		response.getWriter().append("{\"token\" : \"" + token + "\",").append("\"profile\" : {")
				.append("\"userId\" : \"" + user.getId() + "\",")
				.append("\"roleCode\" : \"" + user.getRolesId().getRoleCode() + "\"}").append("}");

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}

}
