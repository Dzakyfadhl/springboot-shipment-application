package com.lawencon.shipment.util;

/**
 *  @author Dzaky Fadhilla Guci
 */

public class TransactionNumberUtil {

  public static String generateShipNumber() {
    return String.format("SHIP-%s", System.currentTimeMillis());
  }

  public static String generateUserCode() {
    return String.format("USER-%s", System.currentTimeMillis());
  }

}
