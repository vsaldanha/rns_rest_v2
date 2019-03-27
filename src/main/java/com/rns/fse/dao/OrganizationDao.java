package com.rns.fse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.OrganizationDetails;
import com.rns.fse.pojo.OrganizationDetailsModel;
import com.rns.fse.repository.OrganizationRepo;

@Component
public class OrganizationDao {


	@Autowired
	private OrganizationRepo organizationRepo;
	
	public List<OrganizationDetailsModel> fetchAllOrganization(){
		List<OrganizationDetailsModel> organizationData = new ArrayList<OrganizationDetailsModel>();
		OrganizationDetailsModel organizationModel = null;
		List<OrganizationDetails> organizationDetails = organizationRepo.findAll();
		for(OrganizationDetails org : organizationDetails){
			organizationModel = new OrganizationDetailsModel();
			organizationModel.setId(org.getId());
			organizationModel.setOrganizationName(org.getOrganizationName());
			organizationModel.setAddress(org.getAddress());
			organizationModel.setHrEmail(org.getHrEmail());
			organizationModel.setHrPhNumber(org.getHrPhNumber());
			organizationData.add(organizationModel);
		}
		return organizationData;
	}
	
}
