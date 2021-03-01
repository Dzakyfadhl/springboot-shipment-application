package com.lawencon.shipment.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.lawencon.shipment.helper.WebResponse;

/**
 * @author Dzaky Fadhilla Guci
 */
public class WebResponseUtils {

  public static <R> ResponseEntity<WebResponse<R>> createWebResponse(R result,
      HttpStatus status) {
    WebResponse<R> webResponse = new WebResponse<>(status.value(), result);
    return new ResponseEntity<>(webResponse, status);
  }


  public static WebResponse<String> createFailedAuthResponse(String message) {
    return new WebResponse<>(HttpStatus.UNAUTHORIZED.value(), message);
  }

}
