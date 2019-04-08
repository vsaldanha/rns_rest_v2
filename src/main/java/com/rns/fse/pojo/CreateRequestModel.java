package com.rns.fse.pojo;

import java.util.List;

public class CreateRequestModel {
	private String schoolName;
	private String eventType;
	private String eventDate;
	public CreateRequestModel() {
		super();
	}
	private String eventstatus;
	private List<CreateSubRequest> subRequestDetails;

	
	public String getEventstatus() {
		return eventstatus;
	}
	public void setEventstatus(String eventstatus) {
		this.eventstatus = eventstatus;
	}

	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public List<CreateSubRequest> getSubRequestDetails() {
		return subRequestDetails;
	}
	public void setSubRequestDetails(List<CreateSubRequest> subRequestDetails) {
		this.subRequestDetails = subRequestDetails;
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

}
