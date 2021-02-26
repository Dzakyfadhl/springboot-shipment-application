package com.lawencon.shipment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.shipment.model.Receivers;
import com.lawencon.shipment.model.Shipments;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface ReceiversRepo extends JpaRepository<Receivers, Long> {

	@Query(value = "select r.id, r.receiverCode, r.receiverName , r.receiverPhone ,r.receiverAddress, r.arrivalTime , r.receiveStatus, s.shippingCode from Receivers as r inner join r.shipmentId as s inner join s.courierId as c where c.id = ?1")
	List<Object[]> getReceiverByCourierId(Long id) throws Exception;

	List<Receivers> findByShipmentId(Shipments shipment) throws Exception;

	@Query(value = "SELECT r FROM Receivers r INNER JOIN r.shipmentId s INNER JOIN s.courierId c WHERE c.employeeCode = ?1")
	List<Receivers> getByCourier(String empCode) throws Exception;

	long count();

}
