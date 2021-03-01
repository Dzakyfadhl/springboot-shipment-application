package com.lawencon.shipment.model;

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
@Table(name = "tb_m_roles",
    uniqueConstraints = {@UniqueConstraint(name = "bk_role", columnNames = "code")})
public class Roles extends BaseMaster {

  private static final long serialVersionUID = 1L;


  @Column(nullable = false, length = 50)
  private String code;

  @Column(nullable = false, length = 50)
  private String name;


}
