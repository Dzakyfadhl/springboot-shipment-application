package com.lawencon.shipment.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.lawencon.shipment.model.Receivers;
import lombok.Data;

/**
 *  @author Dzaky Fadhilla Guci
 */

@Data
public class ShipmentRequestDTO {

  @NotBlank
  @Size(min = 32, max = 36)
  private String bracnhId;

  @NotBlank
  @Size(min = 32, max = 36)
  private String cashierId;

  @NotBlank
  @Size(min = 32, max = 36)
  private String courierId;

  @NotBlank
  @Size(min = 32, max = 36)
  private String serviceId;

  @NotNull
  private List<Receivers> listReceivers;

}
