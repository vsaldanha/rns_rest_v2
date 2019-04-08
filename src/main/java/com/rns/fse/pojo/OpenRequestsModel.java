package com.rns.fse.pojo;

public class OpenRequestsModel {

    private String schoolName;

    private String address;

    private String eventType;

    private String eventDate;
    
    private String classes;
    
    private String status;

   

    public String getSchoolName() {

                    return schoolName;

    }

    public void setSchoolName(String schoolName) {

                    this.schoolName = schoolName;

    }

    public String getAddress() {

                    return address;

    }

    public void setAddress(String address) {

                    this.address = address;

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

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
