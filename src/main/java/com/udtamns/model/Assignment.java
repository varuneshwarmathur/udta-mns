package com.udtamns.model;

import org.springframework.data.annotation.Id;

public class Assignment {
	@Id private String id;
	private String oracleID;
	private String assignmentStartDate;
	private String assignmentEndDate;
	private String visaRenewDate;
	private String policyTravelled;
	private String firstName;
	private String lastName;
	public String getPolicyTravelled() {
		return policyTravelled;
	}
	public void setPolicyTravelled(String policyTravelled) {
		this.policyTravelled = policyTravelled;
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
	public String getOracleID() {
		return oracleID;
	}
	public void setOracleID(String oracleID) {
		this.oracleID = oracleID;
	}
	public String getAssignmentStartDate() {
		return assignmentStartDate;
	}
	public void setAssignmentStartDate(String assignmentStartDate) {
		this.assignmentStartDate = assignmentStartDate;
	}
	public String getAssignmentEndDate() {
		return assignmentEndDate;
	}
	public void setAssignmentEndDate(String assignmentEndDate) {
		this.assignmentEndDate = assignmentEndDate;
	}
	public String getVisaRenewDate() {
		return visaRenewDate;
	}
	public void setVisaRenewDate(String visaRenewDate) {
		this.visaRenewDate = visaRenewDate;
	}
	public Assignment() {}
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, oracleID='%s',assignmentStartDate='%s',assignmentEndDate='%s',visaRenewDate='%s',policyTravelled='%s',firstName='%s',lastName='%s']",
                id, oracleID, assignmentStartDate, assignmentEndDate, visaRenewDate, policyTravelled, firstName, lastName);
    }
}
