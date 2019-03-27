package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.SchoolDetailsDao;
import com.rns.fse.pojo.SchoolDetailsModel;
import com.rns.fse.service.intf.SchoolService;

@Component
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDetailsDao schoolDetailsDao;
	
	@Override
	public List<SchoolDetailsModel> fetchSchoolDetailsService() {
		List<SchoolDetailsModel> schoolDetailsModel = schoolDetailsDao.fetchSchoolDetails();
		return schoolDetailsModel;
	}

}
