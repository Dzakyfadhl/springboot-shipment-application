package com.lawencon.shipment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.ServiceShipments;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ServiceShipRepo extends JpaRepository<ServiceShipments, String> {

	ServiceShipments findByServiceCode(String serviceCode) throws Exception;

}
