package com.rns.fse.pojo;

import com.rns.fse.entities.SchoolDetails;

public class RequestModel {
	
	private String id;
	private int schoolId;
	private String eventType;
	private String eventDate;
	private String status;
	private String creationDate;
	private SchoolDetails schoolDetails;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public SchoolDetails getSchoolDetails() {
		return schoolDetails;
	}
	public void setSchoolDetails(SchoolDetails schoolDetails) {
		this.schoolDetails = schoolDetails;
	}

}
