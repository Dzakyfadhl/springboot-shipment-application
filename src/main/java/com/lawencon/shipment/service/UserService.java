package com.lawencon.shipment.service;

import java.util.List;

import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface UserService {

	List<Users> getListUsers() throws Exception;

	Users getUserByCode(String userCode) throws Exception;

	void insertUser(Users user) throws Exception;

	Users loginUsernamePassword(Users user) throws Exception;

	Users findByUsername(String username) throws Exception;

	Long getIdByUserCode(String userCode) throws Exception;

}
