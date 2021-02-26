package com.lawencon.shipment.helper;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Dzaky Fadhilla Guci
 */

@JsonInclude(Include.NON_NULL)
public class Response<D> {

	private Integer code;
	private HttpStatus status;
	private D data;
	private String message;

	public Response(HttpStatus status, D data) {
		this.code = status.value();
		this.status = status;
		this.data = data;
	}

	public Response(HttpStatus status) {
		this.code = status.value();
		this.status = status;
	}

	public Response(HttpStatus status, String message) {
		this.code = status.value();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setHttpStatus(HttpStatus status) {
		this.status = status;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
