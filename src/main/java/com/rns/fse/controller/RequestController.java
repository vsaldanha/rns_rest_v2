package com.rns.fse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rns.fse.pojo.OpenRequestsModel;
import com.rns.fse.pojo.RequestModel;
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

}