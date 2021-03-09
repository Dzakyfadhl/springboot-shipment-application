package com.lawencon.shipment.controller;

import java.sql.SQLException;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.lawencon.shipment.error.DataIsNotExistException;
import com.lawencon.shipment.error.IllegalRequestException;
import com.lawencon.shipment.helper.WebResponse;
import com.lawencon.shipment.util.WebResponseUtils;

/**
 * @author Dzaky Fadhilla Guci
 */

@RestControllerAdvice
public class ErrorController {

  @ExceptionHandler(value = {IllegalRequestException.class, ConstraintViolationException.class,
      DataIsNotExistException.class})
  public ResponseEntity<WebResponse<String>> validationHandler(Exception e) {
    e.printStackTrace();
    return WebResponseUtils.createWebResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {SQLException.class})
  public ResponseEntity<WebResponse<String>> sqlHandler(SQLException e) {
    e.printStackTrace();
    return WebResponseUtils.createWebResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
  }


}
