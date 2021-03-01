package com.lawencon.shipment.model;

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
@Table(name = "tb_dtl_items")
public class ItemDetails extends BaseTransaction {

  private static final long serialVersionUID = 1L;


  @Column(name = "item_name", nullable = false, length = 50)
  private String itemName;

  @Column(columnDefinition = "TEXT", length = 100)
  private String description;

  @Column(nullable = false)
  private Double weight;

  @ManyToOne
  @JoinColumn(name = "receiver_id", nullable = false ,foreignKey = @ForeignKey(name = "fk_receiver"))
  private Receivers receivers;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_category"))
  private Categories categories;



}
