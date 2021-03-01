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
@Table(name = "tb_m_senders",
    uniqueConstraints = {@UniqueConstraint(name = "bk_sender", columnNames = {"sender_code"})})
public class Senders extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "sender_code", nullable = false, length = 50)
  private String senderCode;

  @Column(name = "fullname", nullable = false, length = 100)
  private String fullName;

  @Column(nullable = false, length = 15)
  private String phone;

  @Column(nullable = false, length = 100)
  private String address;


}
