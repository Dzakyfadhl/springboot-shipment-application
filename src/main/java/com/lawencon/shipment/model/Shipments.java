package com.lawencon.shipment.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_r_hdr_shippings")
// @JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "branchId",
// "cashierId", "courierId",
// "serviceId" })
public class Shipments extends BaseTransaction {

  private static final long serialVersionUID = 1L;

  @Column(name = "total_price")
  private BigDecimal totalPrice;

  @ManyToOne // (fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id", nullable = false, foreignKey = @ForeignKey(name = "fk_branch"))
  private BranchRegions branch;

  @ManyToOne // (fetch = FetchType.LAZY)
  @JoinColumn(name = "cashier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cashier"))
  private EmployeeProfiles cashier;

  @ManyToOne // (fetch = FetchType.LAZY)
  @JoinColumn(name = "courier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_courier"))
  private EmployeeProfiles courier;

  @ManyToOne // (fetch = FetchType.LAZY)
  @JoinColumn(name = "service_id", nullable = false, foreignKey = @ForeignKey(name = "fk_service"))
  private ServiceShipments service;



}
