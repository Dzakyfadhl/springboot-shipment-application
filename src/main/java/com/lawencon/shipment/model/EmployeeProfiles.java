package com.lawencon.shipment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "tb_m_employee_profiles",
    uniqueConstraints = {@UniqueConstraint(columnNames = "employee_code", name = "bk_code"),
        @UniqueConstraint(columnNames = "phone", name = "bk_phone")})
public class EmployeeProfiles extends BaseMaster {

  private static final long serialVersionUID = 1L;

  @Column(name = "employee_code", nullable = false, length = 100)
  private String employeeCode;

  @Column(name = "fullname", nullable = false, length = 100)
  private String fullName;

  @Column(nullable = false, length = 15)
  private String phone;

  @Column(nullable = false, length = 100)
  private String address;

  @OneToOne
  @JoinColumn(name = "users_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
  private Users users;



}
