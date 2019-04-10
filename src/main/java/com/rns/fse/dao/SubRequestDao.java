package com.rns.fse.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.Request;
import com.rns.fse.entities.SubRequest;
import com.rns.fse.pojo.ConfirmSubRequest;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.pojo.TrendingOrgModel;
import com.rns.fse.pojo.TrendingVolModel;
import com.rns.fse.repository.SaveSubRequestRepo;
import com.rns.fse.repository.SubRequestRepo;
import com.rns.fse.repository.TrendingOrgRepo;

@Component
public class SubRequestDao {

	@Autowired
	private SubRequestRepo subRequestRepo;
	
	@Autowired 
	private	TrendingOrgRepo trendingOrgRepo;
	
	@Autowired
	private SaveSubRequestRepo saveSubRequestRepo;
	
	public List<SubRequestModel> fetchAllSubRequest(){
		
		List<SubRequestModel> subRequestData = new ArrayList<SubRequestModel>();
		SubRequestModel subRequestModel = null;
		List<SubRequest> subRequest = subRequestRepo.findAll();
		for(SubRequest sr : subRequest){
			subRequestModel = new SubRequestModel();
			//subRequestModel.setId(sr.getId());
			subRequestModel.setRequestId(sr.getRequestId());
			subRequestModel.setOrganizationName(sr.getOrganizationName());
			subRequestModel.setStatus(sr.getStatus());
			subRequestModel.setSubject(sr.getSubject());
			subRequestModel.setClassGrade(sr.getClassGrade());
			subRequestModel.setTimePeriod(sr.getTimePeriod());
			subRequestModel.setVolunteerName(sr.getVolunteerName());
			subRequestData.add(subRequestModel);
		}
		return subRequestData;
	}
	
	public List<TrendingOrgModel> fetchTrendingOrg(){
	
		TrendingOrgModel trendingOrg;
		List<TrendingOrgModel> trendingOrgModel = new ArrayList<TrendingOrgModel>();
		List<Object[]> results = trendingOrgRepo.findOrganizationNameAndSumTimePeriod();
		for(Object[] res : results) {
			trendingOrg = new TrendingOrgModel();
			String x =(String) res[0];
			BigInteger y = (BigInteger) res[1];
			trendingOrg.setOrganizationName(x);
			trendingOrg.setTimePeriod(y.intValue());
			trendingOrgModel.add(trendingOrg);
		}
		return trendingOrgModel;
	}
	
	public List<TrendingVolModel> fetchTrendingVol(){
		
		TrendingVolModel trendingVol;
		List<TrendingVolModel> trendingVolModel = new ArrayList<TrendingVolModel>();
		List<Object[]> results = trendingOrgRepo.findVolunteerNameAndSumTimePeriod();
		for(Object[] res : results) {
			trendingVol = new TrendingVolModel();
			String x =(String) res[0];
			String y = (String) res[1];
			BigInteger t = (BigInteger) res[2];
			trendingVol.setVolunteerName(x);
			trendingVol.setOrg_name(y);
			trendingVol.setTimePeriod(t.intValue());
			trendingVolModel.add(trendingVol);
		}
		return trendingVolModel;
	}
	
	public String persistSubRequest(ConfirmSubRequest confirmSubRequestModel)
	{
		SubRequest subRequest = new SubRequest();
		subRequest = subRequestRepo.findById(Integer.parseInt(confirmSubRequestModel.getSubReqId()));		
		subRequest.setOrganizationName(confirmSubRequestModel.getOrgName());
		subRequest.setVolunteerName(confirmSubRequestModel.getVolunteer());
		subRequest.setStatus(confirmSubRequestModel.getStatus());
		saveSubRequestRepo.saveSubRequest(subRequest);
		return "sucess";
	}
}
