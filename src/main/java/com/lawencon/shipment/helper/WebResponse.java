package com.lawencon.shipment.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  @author Dzaky Fadhilla Guci
 */

@Data
@AllArgsConstructor
public class WebResponse<R> {

  private Integer code;
  private R result;
}
