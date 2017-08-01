package com.celnet.dc.domain.api.response;

public class OrderResponseJson {

	private String woId;
	
	private String success;
	
	private String workOrderSFID;

	public String getWorkOrderSFID() {
		return workOrderSFID;
	}

	public void setWorkOrderSFID(String workOrderSFID) {
		this.workOrderSFID = workOrderSFID;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
