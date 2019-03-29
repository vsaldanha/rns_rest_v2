package com.rns.fse.service.intf;

import java.util.List;

import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;

public interface RequestService {

	public List<RequestModel> fetchAllRequestService();
	
	public List<OpenRequestsModel> fetchOpenRequest();

	String persistRequest(CreateRequestModel createRequestModel);
}
