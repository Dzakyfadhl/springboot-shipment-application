package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dzaky Fadhilla Guci
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_m_users",
    uniqueConstraints = {@UniqueConstraint(name = "bk_code", columnNames = "user_code"),
        @UniqueConstraint(name = "bk_username", columnNames = "username")})
@JsonIgnoreProperties(allowSetters = true, value = {"hibernateLazyInitializer", "passwords"})
public class Users extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "user_code", unique = true, nullable = false, length = 100)
  private String userCode;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(name = "user_password", nullable = false, length = 100)
  private String password;

  @ManyToOne // (fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role"))
  private Roles roles;


}
