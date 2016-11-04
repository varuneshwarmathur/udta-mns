package com.udtamns.model;

import org.springframework.data.annotation.Id;

public class Person {

	@Id private String id;

	private String firstName;
	private String lastName;
	private String oracleID;
	private String cosSubmit;
	private String visaDate;
	private String visaRecieveDate;
	private String travelDate;
	private String visaStatus;
	public String getVisaStatus() {
		return visaStatus;
	}
	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}
	public String getOracleID() {
		return oracleID;
	}
	public void setOracleID(String oracleID) {
		this.oracleID = oracleID;
	}
	public String getCosSubmit() {
		return cosSubmit;
	}
	public void setCosSubmit(String cosSubmit) {
		this.cosSubmit = cosSubmit;
	}
	public String getVisaDate() {
		return visaDate;
	}
	public void setVisaDate(String visaDate) {
		this.visaDate = visaDate;
	}
	public String getVisaRecieveDate() {
		return visaRecieveDate;
	}
	public void setVisaRecieveDate(String visaRecieveDate) {
		this.visaRecieveDate = visaRecieveDate;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
	public Person() {}
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', oracleID='%s',"
                + "cosSubmit='%s',visaDate='%s',visaRecieveDate='%s',travelDate='%s',visaStatus='%s']",
                id, firstName, lastName,oracleID, cosSubmit, visaDate, visaRecieveDate, travelDate,visaStatus);
    }
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
