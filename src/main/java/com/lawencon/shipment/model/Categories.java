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
@Table(name = "tb_m_categories",
    uniqueConstraints = {@UniqueConstraint(name = "bk_category", columnNames = "categories_code")})
@JsonInclude(Include.NON_NULL)
public class Categories extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "categories_code", nullable = false, length = 100)
  private String categoriesCode;

  @Column(name = "categories_name", nullable = false, length = 100)
  private String categoriesName;



}
