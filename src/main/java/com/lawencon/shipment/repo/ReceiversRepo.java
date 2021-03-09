package com.lawencon.shipment.repo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ReceiversRepo extends JpaRepository<Receivers, String> {

  @Query(
      value = "select r.id, r.code, r.name , r.phone ,r.address, r.trxTime , r.status, s.trxNumber from Receivers as r inner join r.shipments as s inner join s.courier as c where c.id = ?1")
    List<Object[]> getReceiverByCourier(String id) throws Exception;

    List<Receivers> findByShipments(Shipments shipment) throws Exception;

    @Query(
        value = "SELECT r FROM Receivers r INNER JOIN r.shipments s INNER JOIN s.courier c WHERE c.employeeCode = ?1")
	List<Receivers> getByCourier(String empCode) throws Exception;

    @Modifying
    @Query(
        value = "UPDATE Receivers SET receiveStatus = 'Delivered' , arrivalTime = ?1 WHERE receiver_code = ?2 ")
    void updateStatus(LocalDateTime arrivalTime, String code) throws Exception;

	long count();

}
