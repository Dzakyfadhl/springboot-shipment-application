package com.lawencon.shipment.service;

import java.util.List;
import com.lawencon.shipment.dto.UserCreateRequestDTO;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface UserService {

	List<Users> getListUsers() throws Exception;

	Users getUserByCode(String userCode) throws Exception;

    void insertUser(UserCreateRequestDTO user) throws Exception;

	Users findByUsername(String username) throws Exception;

    String getIdByUserCode(String userCode) throws Exception;

    void UpdateUser(Users newUser) throws Exception;

    Users findById(String id) throws Exception;

}
