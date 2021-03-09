package com.lawencon.shipment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *  @author Dzaky Fadhilla Guci
 */

@Data
public class UserCreateRequestDTO {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  @NotBlank
  @Size(min = 32, max = 36)
  private String roleId;

  @NotBlank
  private String createdBy;

  @NotBlank
  private String json;

}
