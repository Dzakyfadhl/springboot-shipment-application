package com.lawencon.shipment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Dzaky Fadhilla Guci
 */

@Entity
@Table(name = "tb_r_dtl_receiver")
public class Receivers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "receiver_code", nullable = false, length = 50, unique = true)
	private String receiverCode;

	@Column(name = "receiver_name", nullable = false, length = 50)
	private String receiverName;

	@Column(name = "receiver_phone", nullable = false, length = 15)
	private String receiverPhone;

	@Column(name = "receiver_address", nullable = false, length = 100)
	private String receiverAddress;

	@Column(name = "receive_status", nullable = false, length = 30)
	private String receiveStatus;

	@ManyToOne
	@JoinColumn(name = "shipping_id", nullable = false)
	private Shipments shipmentId;

	@ManyToOne
	@JoinColumn(name = "senders_id", nullable = false)
	private Senders senderId;

	@Column(name = "arrival_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime arrivalTime;

	@Transient
	private List<ItemDetails> listItemsReceiver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceiverCode() {
		return receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Shipments getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Shipments shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Senders getSenderId() {
		return senderId;
	}

	public void setSenderId(Senders senderId) {
		this.senderId = senderId;
	}

	public List<ItemDetails> getListItemsReceiver() {
		return listItemsReceiver;
	}

	public void setListItemsReceiver(List<ItemDetails> listItemsReceiver) {
		this.listItemsReceiver = listItemsReceiver;
	}

	public String getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
