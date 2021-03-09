package com.lawencon.shipment.error;

import lombok.NoArgsConstructor;

/**
 *  @author Dzaky Fadhilla Guci
 */

@NoArgsConstructor
public class DataIsNotExistException extends Exception {

  private static final long serialVersionUID = -1812881037890558589L;

  public DataIsNotExistException(String param, String value) {
    super(String.format("Data is not exist with %s : %s", param, value));
  }

  public DataIsNotExistException(String message) {
    super(message);
  }
}
