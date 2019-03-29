package com.rns.fse.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request", schema = "rns")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id")
	private int id;
	
	@Column(name = "school_id")
	private int schoolId;
	
	@Column(name = "even_type")
	private String eventType;
	
	@Column(name = "event_date")
	private String eventDate;

	@Column(name = "status")
	private String status;

	@Column(name = "creation_date")
	private String creationDate;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "school_id", insertable = false, updatable = false)
	private SchoolDetails schoolDetails;

	public int getId() {
		return id;
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
