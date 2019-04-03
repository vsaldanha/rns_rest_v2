package com.rns.fse.service.intf;

import java.util.List;

import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
import com.rns.fse.pojo.SubRequestResponse;

public interface RequestService {

	public List<RequestModel> fetchAllRequestService();
	
	public List<OpenRequestsModel> fetchOpenRequest();
	
	public List<SubRequestResponse> fetchAllSubRequest();

	String persistRequest(CreateRequestModel createRequestModel);
}
