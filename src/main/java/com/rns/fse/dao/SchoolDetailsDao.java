package com.rns.fse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.SchoolDetails;
import com.rns.fse.pojo.SchoolDetailsModel;
import com.rns.fse.repository.SchoolDetailsRepo;


@Component
public class SchoolDetailsDao {
	

	@Autowired
	private SchoolDetailsRepo schoolDetailsRepo;
	
	public List<SchoolDetailsModel> fetchSchoolDetails(){
		List<SchoolDetailsModel> schoolData = new ArrayList<SchoolDetailsModel>();
		SchoolDetailsModel schoolModel = null;
		List<SchoolDetails> schoolDetails = schoolDetailsRepo.findAll();
		for(SchoolDetails sd : schoolDetails){
			schoolModel = new SchoolDetailsModel();
			schoolModel.setId(sd.getId());
			schoolModel.setSchoonName(sd.getSchoolName());
			schoolModel.setAddress(sd.getAddress());
			schoolModel.setPrincipal(sd.getPrincipal());
			schoolModel.setPhNumber(sd.getPhNumber());
			schoolData.add(schoolModel);
		}
		
		return schoolData;
	}

}
