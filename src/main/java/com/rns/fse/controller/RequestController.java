package com.rns.fse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rns.fse.pojo.ConfirmSubRequest;
import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.SubRequestResponse;
import com.rns.fse.pojo.TrendingOrgModel;
import com.rns.fse.pojo.TrendingVolModel;
import com.rns.fse.service.impl.RequestServiceImpl;
import com.rns.fse.service.impl.SubRequestServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class RequestController {

	@Autowired
	private SubRequestServiceImpl subRequestService;

	@Autowired
	private RequestServiceImpl requestServiceImpl;
	
	@Autowired
	private SubRequestServiceImpl subRequestServiceImpl;

	@RequestMapping(value = "/getTrendingOrg", method = RequestMethod.GET)
	public List<TrendingOrgModel> getSubRequestDetails() {
		List<TrendingOrgModel> trendingOrgModel = subRequestService.fetchTrendingOrg();
		return trendingOrgModel;
	}

	@RequestMapping(value = "/getTrendingVolunteer", method = RequestMethod.GET)
	public List<TrendingVolModel> getSubRequestVolDetails() {
		List<TrendingVolModel> trendingVolModel = subRequestService.fetchTrendingVol();
		return trendingVolModel;
	}

	@RequestMapping(value = "/getOpenRequests", method = RequestMethod.GET)
	public List<OpenRequestsModel> getOpenRequests() {
		List<OpenRequestsModel> requestModel = requestServiceImpl.fetchOpenRequest();
		return requestModel;

	}
	
//	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
//	public List<OpenRequestsModel> registerUser() {
//		List<OpenRequestsModel> requestModel = requestServiceImpl.fetchOpenRequest();
//		return requestModel;
//
//	}
	
	
	@RequestMapping(value = "/getAllSubRequestDetails", method = RequestMethod.GET)
	public List<SubRequestResponse> getAllSubRequestDetails() {
		List<SubRequestResponse> requestModel = requestServiceImpl.fetchAllSubRequest();
		return requestModel;

	}
	
	@RequestMapping(value = "/createOpenRequests", method = RequestMethod.POST)
	public String createOpenRequests(@RequestBody CreateRequestModel createRequestModel) {
		String resp = requestServiceImpl.persistRequest(createRequestModel);
		return resp;

	}
	
	@RequestMapping(value = "/saveRequests", method = RequestMethod.POST)
	public String saveSubRequest(@RequestBody ConfirmSubRequest confirmSubRequestModel) {
		String resp = subRequestServiceImpl.persistSubRequest(confirmSubRequestModel);
		return resp;

	}
	
	@RequestMapping(value = "/FetchAllOpenSubRequests", method = RequestMethod.GET)
	public List<SubRequestResponse> getAllOpenRequestDetails() {
		List<SubRequestResponse> requestModel = requestServiceImpl.fetchAllOpenSubRequest();
		return requestModel;

	}

}
