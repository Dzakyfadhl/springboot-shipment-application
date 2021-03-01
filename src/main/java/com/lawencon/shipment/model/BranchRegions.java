package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
@Table(name = "tb_m_branch_regions",
    uniqueConstraints = {@UniqueConstraint(name = "bk_branchs", columnNames = {"branch_code"})})
public class BranchRegions extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "branch_code", nullable = false, length = 100)
  private String branchCode;

  @Column(nullable = false, length = 100)
  private String region;

  @Column(nullable = false, length = 15)
  private String phone;

  @Column(nullable = false)
  private String address;

}
