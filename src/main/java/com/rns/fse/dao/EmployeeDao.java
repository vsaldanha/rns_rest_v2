package com.rns.fse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.EmployeeDetails;
import com.rns.fse.pojo.EmployeeDetailsModel;
import com.rns.fse.repository.EmployeeRepo;

@Component
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<EmployeeDetailsModel> fetechAllEmployee(){
		List<EmployeeDetailsModel> employeeData = new ArrayList<EmployeeDetailsModel>();
		EmployeeDetailsModel employeeModel = null;
		List<EmployeeDetails> employee = employeeRepo.findAll();
		for(EmployeeDetails emp : employee){
			employeeModel = new EmployeeDetailsModel();
			employeeModel.setId(emp.getId());
			employeeModel.setEmployeeName(emp.getEmployeeName());
			employeeModel.setOrganizationId(emp.getOrganizationId());
			//employeeModel.setAddress(emp.getAddress());
			employeeModel.setEmail(emp.getEmail());
			employeeModel.setPhNumber(emp.getPhNumber());
			employeeData.add(employeeModel);		
		}
		return employeeData;
	}

}
