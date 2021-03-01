package com.lawencon.shipment.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseTransaction extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "trx_number")
	private String trxNumber;

	@Column(name = "trx_date")
    private LocalDateTime trxTime;

	public String getTrxNumber() {
		return trxNumber;
	}

	public void setTrxNumber(String trxNumber) {
		this.trxNumber = trxNumber;
	}

    public LocalDateTime getTrxTime() {
      return trxTime;
	}

    public void setTrxTime(LocalDateTime trxTime) {
      this.trxTime = trxTime;
	}

}