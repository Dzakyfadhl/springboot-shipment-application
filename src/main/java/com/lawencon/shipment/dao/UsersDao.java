package com.lawencon.shipment.dao;

import java.util.List;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface UsersDao {

  String getIdByUserCode(String userCode) throws Exception;

	List<Users> getListUsers() throws Exception;

	Users getUserByCode(String userCode) throws Exception;

	Users loginUserByUsernamePassword(Users user) throws Exception;

	void insertUser(Users user) throws Exception;

	Users findByUsername(String username) throws Exception;

	Long countData() throws Exception;

    void updateUser(Users user) throws Exception;

    Users findById(String id) throws Exception;

}
