package com.lawencon.shipment.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_m_services",
    uniqueConstraints = {@UniqueConstraint(name = "bk_service", columnNames = {"service_code"})})
public class ServiceShipments extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "service_code", nullable = false, length = 100)
  private String serviceCode;

  @Column(name = "service_name", nullable = false, length = 100)
  private String serviceName;

  @Column(name = "service_price", nullable = false)
  private BigDecimal servicePrice;


}
