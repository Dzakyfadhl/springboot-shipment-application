package com.lawencon.shipment.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.Users;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {

	@Query(value = "SELECT id FROM Users WHERE userCode = ?1")
    String getIdByUserCode(String userCode) throws Exception;

	Users findByUserCode(String userCode) throws Exception;

	Users findByUsername(String username) throws Exception;

    Users findByPassword(String passwords) throws Exception;

    @Query(
        value = "select u.id, u.userCode , u.roles.code, u.roles.name, u.roles.id as id_role from Users as u where username = ?1 and passwords = ?2")
	List<Object[]> login(String username, String password) throws Exception;

	long count();

}
