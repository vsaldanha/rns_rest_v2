package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.RequestDao;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
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

}
