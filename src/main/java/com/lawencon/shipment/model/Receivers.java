package com.lawencon.shipment.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_r_dtl_receiver",
    uniqueConstraints = {@UniqueConstraint(name = "bk_receiver", columnNames = "code")})
public class Receivers extends BaseTransaction {

  private static final long serialVersionUID = 1L;

  @Column(nullable = false, length = 50, unique = true)
  private String code;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, length = 15)
  private String phone;

  @Column(nullable = false, length = 100)
  private String address;

  @Column(nullable = false, length = 30)
  private String status;

  @ManyToOne
  @JoinColumn(name = "shipment_id", nullable = false,
      foreignKey = @ForeignKey(name = "fk_shipment"))
  private Shipments shipments;

  @ManyToOne
  @JoinColumn(name = "sender_id", nullable = false, foreignKey = @ForeignKey(name = "fk_sender"))
  private Senders senders;

  @Column(name = "arrival_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime arrivalTime;

  @Transient
  private List<ItemDetails> listItemsReceiver;



}
