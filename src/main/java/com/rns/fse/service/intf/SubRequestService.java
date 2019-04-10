package com.rns.fse.service.intf;

import java.util.List;

import com.rns.fse.pojo.ConfirmSubRequest;
import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.pojo.TrendingOrgModel;
import com.rns.fse.pojo.TrendingVolModel;

public interface SubRequestService {

	List<SubRequestModel> fetchAllSubRequestService();

	List<TrendingOrgModel> fetchTrendingOrg();
	
	List<TrendingVolModel> fetchTrendingVol();
	
	String persistSubRequest(ConfirmSubRequest confirmSubRequestModel);
}
