package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.OrganizationDao;
import com.rns.fse.pojo.OrganizationDetailsModel;
import com.rns.fse.service.intf.OrganizationService;

@Component
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<OrganizationDetailsModel> fetchAllOrganizationService() {
		List<OrganizationDetailsModel> organizationModel = organizationDao.fetchAllOrganization();
		return organizationModel;
	}

}
