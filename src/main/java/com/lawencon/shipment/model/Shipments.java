package com.lawencon.shipment.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Table(name = "tb_r_hdr_shippings")
//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "branchId", "cashierId", "courierId",
//		"serviceId" })
public class Shipments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "shipping_code", unique = true, nullable = false, length = 100)
	private String shippingCode;

	@Column(name = "transaction_time", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime trancastionTime;

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id", nullable = false)
	private BranchRegions branchId;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "cashier_id", nullable = false)
	private EmployeeProfiles cashierId;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "couriers_id", nullable = false)
	private EmployeeProfiles courierId;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id", nullable = false)
	private ServiceShipments serviceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public LocalDateTime getTrancastionTime() {
		return trancastionTime;
	}

	public void setTrancastionTime(LocalDateTime trancastionTime) {
		this.trancastionTime = trancastionTime;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BranchRegions getBranchId() {
		return branchId;
	}

	public void setBranchId(BranchRegions branchId) {
		this.branchId = branchId;
	}

	public EmployeeProfiles getCashierId() {
		return cashierId;
	}

	public void setCashierId(EmployeeProfiles cashierId) {
		this.cashierId = cashierId;
	}

	public EmployeeProfiles getCourierId() {
		return courierId;
	}

	public void setCourierId(EmployeeProfiles courierId) {
		this.courierId = courierId;
	}

	public ServiceShipments getServiceId() {
		return serviceId;
	}

	public void setServiceId(ServiceShipments serviceId) {
		this.serviceId = serviceId;
	}

}
