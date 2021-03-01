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
public interface ShipmentsRepo extends JpaRepository<Shipments, String> {

	@Modifying
	@Query(value = "UPDATE Shipments set totalPrice = ?1 + ?2 WHERE id = ?3 ")
    void updateTotalPrice(BigDecimal totalPrice, BigDecimal servicePrice, String id)
        throws Exception;

    @Query(value = "SELECT s FROM Shipments s WHERE cashier.id = ?1 ")
    List<Shipments> getByCashier(String id) throws Exception;

    Shipments findByTrxNumber(String code) throws Exception;

    @Query(value = "FROM Shipments ORDER BY trxTime DESC")
	List<Shipments> findAllOrderByTrancastionTime();

    List<Shipments> findByCourier(EmployeeProfiles courier) throws Exception;

}
