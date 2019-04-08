package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.RequestDao;
import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
import com.rns.fse.pojo.SubRequestResponse;
import com.rns.fse.service.intf.RequestService;

@Component
public class RequestServiceImpl implements RequestService{

	@Autowired
	private RequestDao requestDao;
	
	@Override
	public List<RequestModel> fetchAllRequestService() {
		List<RequestModel> requestModel = requestDao.fetchAllRequest();
		return requestModel;
	}
	
	@Override
	public List<OpenRequestsModel> fetchOpenRequest() {
		List<OpenRequestsModel> requestModel = requestDao.fetchOpenRequest();
		return requestModel;
	}
	
	@Override
	public List<SubRequestResponse> fetchAllSubRequest() {
		List<SubRequestResponse> requestModel = requestDao.fetchAllSubRequest();
		return requestModel;
	}
	
	@Override
	public List<SubRequestResponse> fetchAllOpenSubRequest() {
		List<SubRequestResponse> requestModel = requestDao.fetchAllOpenSubRequest();
		return requestModel;
	}
	
	@Override
	public String persistRequest(CreateRequestModel createRequestModel) {
		String resp = requestDao.persistRequest(createRequestModel);
		return resp;
	}

}
