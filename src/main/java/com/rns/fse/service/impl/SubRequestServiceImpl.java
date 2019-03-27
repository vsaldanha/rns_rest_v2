package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.SubRequestDao;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.pojo.TrendingOrgModel;
import com.rns.fse.pojo.TrendingVolModel;
import com.rns.fse.service.intf.SubRequestService;

@Component
public class SubRequestServiceImpl implements SubRequestService{

	@Autowired
	SubRequestDao subRequestDao;
	
	@Override
	public List<TrendingVolModel> fetchTrendingVol() {
		List<TrendingVolModel> trendingVolModel = subRequestDao.fetchTrendingVol();
		for(TrendingVolModel org: trendingVolModel)
		{
			System.out.println(org.getVolunteerName()+" : "+org.getTimePeriod());
		}
		return trendingVolModel;
	}
	
	public List<TrendingOrgModel> fetchTrendingOrg() {
		List<TrendingOrgModel> trendingOrgModel = subRequestDao.fetchTrendingOrg();
		for(TrendingOrgModel org: trendingOrgModel)
		{
			System.out.println(org.getOrganizationName()+" : "+org.getTimePeriod());
		}
		return trendingOrgModel;
	}

	@Override
	public List<SubRequestModel> fetchAllSubRequestService() {
		List<SubRequestModel> subRequestModel = subRequestDao.fetchAllSubRequest();
		return subRequestModel;
	}

	
}
