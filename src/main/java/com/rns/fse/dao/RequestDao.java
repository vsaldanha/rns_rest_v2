package com.rns.fse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.Request;
import com.rns.fse.entities.SchoolDetails;
import com.rns.fse.entities.SubRequest;
import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.CreateSubRequest;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.pojo.SubRequestResponse;
import com.rns.fse.repository.OpenRequestsRepo;
import com.rns.fse.repository.PersistRequestRepository;
import com.rns.fse.repository.RequestRepo;
import com.rns.fse.repository.SchoolDetailsRepo;
import com.rns.fse.repository.SubRequestRepo;

@Component
public class RequestDao {

	@Autowired
	private RequestRepo requestRepo;
	
	@Autowired
	private SubRequestRepo subRequestRepo;

	@Autowired
	private SchoolDetailsRepo schoolDetailsRepo;

	@Autowired
	private OpenRequestsRepo openRequestRepo;
	
	@Autowired
	private PersistRequestRepository persistRequestRepository;
	
	private SubRequestResponse subReqResponse;

	@Transactional
	public List<RequestModel> fetchAllRequest() {

		List<RequestModel> requestData = new ArrayList<RequestModel>();
		RequestModel requestModel = null;
		List<Request> request = requestRepo.findAll();
		for (Request req : request) {
			requestModel = new RequestModel();
			//requestModel.setId(req.getId());
			requestModel.setSchoolId(req.getSchoolId());
			requestModel.setEventType(req.getEventType());
			requestModel.setEventType(req.getEventDate());
			requestModel.setStatus(req.getStatus());
			requestModel.setCreationDate(req.getCreationDate());
			requestData.add(requestModel);
		}
		return requestData;

	}

	@Transactional
	public List<OpenRequestsModel> fetchOpenRequest() {
		SchoolDetails schoolDetails = null;
		List<SubRequest> subRequest = null;
		OpenRequestsModel openRequest = null;
		String classes = "";
		List<OpenRequestsModel> requestModel = new ArrayList<OpenRequestsModel>();
		List<Object[]> results = openRequestRepo.fetchOpenRequest();
		for (Object[] res : results) {
			openRequest = new OpenRequestsModel();
			int x = (int) res[0];
			int y = (int) res[1];
			String eventType = (String) res[2];
			String eventDate = (String) res[3];
			System.out.println(y);
			schoolDetails = schoolDetailsRepo.findById(y);
			subRequest = subRequestRepo.findByRequestId(x);
			for(SubRequest sr : subRequest){
			classes = classes + sr.getSubject()+" : " + sr.getTimePeriod() + "hours; ";
			}
			System.out.println(classes);
			openRequest.setClasses(classes);
			//System.out.println(schoolDetails.getSchoolName());
			openRequest.setSchoolName(schoolDetails.getSchoolName());
			openRequest.setAddress(schoolDetails.getAddress());
			openRequest.setEventType(eventType);
			openRequest.setEventDate(eventDate);
			openRequest.setStatus((String)res[4]);
			requestModel.add(openRequest);
			classes = "";
		}
		return requestModel;
	}

	@Transactional
	public String persistRequest(CreateRequestModel requestModel){
		Request request = new Request();
		String resp = "success";
		SubRequest subRequest;
		List<CreateSubRequest> createSubRequest;
		request.setEventType(requestModel.getEventType());
		System.out.println("*****->"+requestModel.getEventType());
		request.setEventDate(requestModel.getEventDate());
		SchoolDetails schoolDet = schoolDetailsRepo.findBySchoolName(requestModel.getSchoolName());
		request.setSchoolId(schoolDet.getId());
		request.setStatus("Open");
		createSubRequest = requestModel.getSubRequestDetails();
		System.out.println(requestModel.getSubRequestDetails());
		int requestID = persistRequestRepository.persistRequest(request);
		for(CreateSubRequest crs : createSubRequest){
			System.out.println(crs.getClassGrade() +" : "+crs.getSubject());
			subRequest = new SubRequest();
			subRequest.setClassGrade(crs.getClassGrade());
			subRequest.setSubject(crs.getSubject());
			subRequest.setTimePeriod(crs.getTimePeriod());
			subRequest.setStatus("Open");
			subRequest.setRequestId(requestID);
			persistRequestRepository.persistSubRequest(subRequest);
		}		
		
		return resp;
			
	}
	
	@Transactional
	public List<SubRequestResponse> fetchAllSubRequest() {
		
		List<SubRequestResponse> subReqList= new ArrayList<SubRequestResponse>();
		List<Object[]> results = openRequestRepo.fetchAllRequest();
		for (Object[] res : results) {
			
			subReqResponse = new SubRequestResponse();
			
			subReqResponse.setEventType((String) res[0]);
			subReqResponse.setEventDate((String) res[1]);
			subReqResponse.setClassGrade((String) res[2]);
			subReqResponse.setSubject((String) res[3]);
			subReqResponse.setTimePeriod((Integer) res[4]);
			subReqResponse.setStatus((String) res[5]);
			subReqList.add(subReqResponse);
		}
		return subReqList;
	}
	
	@Transactional
	public List<SubRequestResponse> fetchAllOpenSubRequest() {
		SchoolDetails schoolDetails = null;
		List<SubRequestResponse> subReqList= new ArrayList<SubRequestResponse>();
		List<Object[]> results = openRequestRepo.fetchAllOpenSubRequest();
		for (Object[] res : results) {
			int y = (int) res[0];
			schoolDetails = schoolDetailsRepo.findById(y);
			subReqResponse = new SubRequestResponse();
			subReqResponse.setSchoolName(schoolDetails.getSchoolName());
			subReqResponse.setEventType((String) res[1]);
			subReqResponse.setEventDate((String) res[2]);
			subReqResponse.setClassGrade((String) res[3]);
			subReqResponse.setSubject((String) res[4]);
			subReqResponse.setTimePeriod((Integer) res[5]);
			subReqResponse.setStatus((String) res[6]);
			subReqResponse.setSub_req_id((Integer) res[7]);
			subReqList.add(subReqResponse);
		}
		return subReqList;
	}

}
