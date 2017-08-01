package com.celnet.dc.domain.api.request;

import java.util.List;

public class UnitsInfoInterfaceClass {

	public String token ;
    public String timestamp ;
    public List<HouseOwnerChangeRequestJson> acceptList;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public List<HouseOwnerChangeRequestJson> getAcceptList() {
		return acceptList;
	}
	public void setAcceptList(List<HouseOwnerChangeRequestJson> acceptList) {
		this.acceptList = acceptList;
	}
    
}
