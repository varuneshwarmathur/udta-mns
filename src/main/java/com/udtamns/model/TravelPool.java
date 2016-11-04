package com.udtamns.model;

import org.springframework.data.annotation.Id;

public class TravelPool {
	@Id private String id;
	private String oracleID;
	private String firstName;
	private String lastName;
	private String validPassport;
	private String eligibleForVisa;
	private String visaReady;
	private String domain;
	private String assignmentType;
	private String notes;
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
	public String getValidPassport() {
		return validPassport;
	}
	public void setValidPassport(String validPassport) {
		this.validPassport = validPassport;
	}
	public String getEligibleForVisa() {
		return eligibleForVisa;
	}
	public void setEligibleForVisa(String eligibleForVisa) {
		this.eligibleForVisa = eligibleForVisa;
	}
	public String getVisaReady() {
		return visaReady;
	}
	public void setVisaReady(String visaReady) {
		this.visaReady = visaReady;
	}

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public TravelPool() {}
	@Override
    public String toString() {
        return String.format(
                "{\"id\":\"%s\", \"oracleID\":\"%s\",\"validPassport\":\"%s\",\"eligibleForVisa\":\"%s\",\"visaReady\":\"%s\",\"Domain\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"assignmentType\":\"%s\",\"notes\":\"%s\",\"size\":1456}",
                id, oracleID, validPassport, eligibleForVisa, visaReady, domain, firstName, lastName, assignmentType, notes);
    }

}
