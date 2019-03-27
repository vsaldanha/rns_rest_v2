package com.rns.fse.pojo;

public class OrganizationDetailsModel {

	private String id;
	private String organizationName;
	private String address;
	private String hrEmail;
	private String hrPhNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHrEmail() {
		return hrEmail;
	}
	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}
	public String getHrPhNumber() {
		return hrPhNumber;
	}
	public void setHrPhNumber(String hrPhNumber) {
		this.hrPhNumber = hrPhNumber;
	}
}
