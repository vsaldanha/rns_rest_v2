package com.rns.fse.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_request", schema = "rns")
public class SubRequest {

	@Id
	@Column(name = "sub_request_id")
	private String id;
	
	@Column(name = "request_id")
	private String requestId;
	
	@Column(name = "class_grade")
	private String classGrade;
	
	@Column(name = "subject")
	private String Subject;

	@Column(name = "time_period")
	private String timePeriod;

	@Column(name = "volunteer_name")
	private String volunteerName;
	
	@Column(name = "organization_name")
	private String OrganizationName;
	
	@Column(name = "status")
	private String status;
	
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "request_id", insertable = false, updatable = false)
	private Request request;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRequestId() {
		return requestId;
	}



	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}



	public String getClassGrade() {
		return classGrade;
	}



	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}



	public String getSubject() {
		return Subject;
	}



	public void setSubject(String subject) {
		Subject = subject;
	}



	public String getTimePeriod() {
		return timePeriod;
	}



	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}



	public String getVolunteerName() {
		return volunteerName;
	}



	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}



	public String getOrganizationName() {
		return OrganizationName;
	}



	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Request getRequest() {
		return request;
	}



	public void setRequest(Request request) {
		this.request = request;
	}
}
