package com.lawencon.shipment.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.model.EmployeeProfiles;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ShipmentsRepo extends JpaRepository<Shipments, Long> {

	@Modifying
	@Query(value = "UPDATE Shipments set totalPrice = ?1 + ?2 WHERE id = ?3 ")
	void updateTotalPrice(BigDecimal totalPrice, BigDecimal servicePrice, Long id) throws Exception;

	@Query(value = "select s from Shipments s where cashierId.id = ?1 ")
	List<Shipments> getByCashierId(Long id) throws Exception;

	Shipments findByShippingCode(String code) throws Exception;

	@Query(value = "FROM Shipments ORDER BY trancastionTime DESC")
	List<Shipments> findAllOrderByTrancastionTime();

	List<Shipments> findByCourierId(EmployeeProfiles courier) throws Exception;

}
