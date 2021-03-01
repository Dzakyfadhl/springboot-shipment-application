package com.lawencon.shipment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.Roles;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface RolesRepo extends JpaRepository<Roles, String> {

}
