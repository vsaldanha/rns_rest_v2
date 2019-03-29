package com.rns.fse.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_details", schema = "rns")
public class SchoolDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "school_id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ph_number")
	private String phNumber;

	@Column(name = "principal")
	private String principal;

	public int getId() {
		return id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoonName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	

}
