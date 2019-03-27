package com.rns.fse.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.Request;
import com.rns.fse.entities.SchoolDetails;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
import com.rns.fse.pojo.TrendingVolModel;
import com.rns.fse.repository.OpenRequestsRepo;
import com.rns.fse.repository.RequestRepo;
import com.rns.fse.repository.SchoolDetailsRepo;

@Component
public class RequestDao {

	@Autowired
	private RequestRepo requestRepo;

	@Autowired
	private SchoolDetailsRepo schoolDetailsRepo;

	@Autowired
	private OpenRequestsRepo openRequestRepo;

	public List<RequestModel> fetchAllRequest() {

		List<RequestModel> requestData = new ArrayList<RequestModel>();
		RequestModel requestModel = null;
		List<Request> request = requestRepo.findAll();
		for (Request req : request) {
			requestModel = new RequestModel();
			requestModel.setId(req.getId());
			requestModel.setSchoolId(req.getSchoolId());
			requestModel.setEventType(req.getEventType());
			requestModel.setEventType(req.getEventDate());
			requestModel.setStatus(req.getStatus());
			requestModel.setCreationDate(req.getCreationDate());
			requestData.add(requestModel);
		}
		return requestData;

	}

	public List<OpenRequestsModel> fetchOpenRequest() {
		SchoolDetails schoolDetails = null;
		OpenRequestsModel openRequest = null;
		List<OpenRequestsModel> requestModel = new ArrayList<OpenRequestsModel>();
		List<Object[]> results = openRequestRepo.fetchOpenRequest();
		for (Object[] res : results) {
			openRequest = new OpenRequestsModel();
			int y = (int) res[1];
			String eventType = (String) res[2];
			String eventDate = (String) res[3];
			System.out.println(y);
			schoolDetails = schoolDetailsRepo.findById(y);
			System.out.println(schoolDetails.getSchoolName());
			openRequest.setSchoonName(schoolDetails.getSchoolName());
			openRequest.setAddress(schoolDetails.getAddress());
			openRequest.setEventType(eventType);
			openRequest.setEventDate(eventDate);
			requestModel.add(openRequest);
		}
		return requestModel;
	}

}
