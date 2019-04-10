package com.rns.fse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.EmployeeDetails;
import com.rns.fse.entities.OrganizationDetails;
import com.rns.fse.entities.UserInfo;
import com.rns.fse.pojo.RegisterUser;
import com.rns.fse.repository.EmployeeRepo;
import com.rns.fse.repository.OrganizationRepo;
import com.rns.fse.repository.RegisterEmployee;
import com.rns.fse.repository.UserInfoRepo;

@Component
public class UserInfoDao {
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	@Autowired
	RegisterEmployee registerEmp;

	public String fetchUserData(String userName, String password) {
		Object role = userInfoRepo.fetchUserInfo(userName, password);
		System.out.println("ROle is:"+role.toString());
		return role.toString();
	}
	
	public String registerUserData(RegisterUser registerUser) {
		UserInfo userInfo = new UserInfo();
		EmployeeDetails employee = new EmployeeDetails();
		OrganizationDetails org = new OrganizationDetails();
		if(registerUser.getUserType().equalsIgnoreCase("school")){
		userInfo.setUserRole("school");			
		}
		if(registerUser.getUserType().equalsIgnoreCase("organization")){
			userInfo.setUserRole("organization");
		}
		else
			userInfo.setUserRole("volunteer");
			userInfo.setUserName(registerUser.getUsername());
			userInfo.setPassword(registerUser.getPassword());
			userInfo.setEmail(registerUser.getPassword());
			userInfoRepo.registerUser(userInfo);
			if(userInfo.getUserRole().equalsIgnoreCase("volunteer")){
			employee.setEmployeeName(registerUser.getUsername());
			org = organizationRepo.findByOrganizationName(registerUser.getOrgName());
			employee.setOrganizationId(org.getId());
			employee.setEmail(registerUser.getEmail());
			employee.setPhNumber(registerUser.getPhone());
			employee.setId(registerUser.getEmpId());
			registerEmp.registerEmp(employee);
		
			}
		
		return null;
	}

}
