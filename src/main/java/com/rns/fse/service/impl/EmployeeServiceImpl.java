package com.rns.fse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.EmployeeDao;
import com.rns.fse.pojo.EmployeeDetailsModel;
import com.rns.fse.service.intf.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao; 

	@Override
	public List<EmployeeDetailsModel> fetechAllEmployeeService() {
		List<EmployeeDetailsModel> employeeModel = employeeDao.fetechAllEmployee();
		return employeeModel;
	}

}
