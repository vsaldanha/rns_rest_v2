package com.rns.fse.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rns.fse.pojo.ApiResponse;
import com.rns.fse.pojo.CreateRequestModel;
import com.rns.fse.pojo.EmployeeDetailsModel;
import com.rns.fse.pojo.OrganizationDetailsModel;
import com.rns.fse.pojo.RegisterUser;
import com.rns.fse.pojo.RequestModel;
import com.rns.fse.pojo.SchoolDetailsModel;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.service.impl.EmployeeServiceImpl;
import com.rns.fse.service.impl.OrganizationServiceImpl;
import com.rns.fse.service.impl.RequestServiceImpl;
import com.rns.fse.service.impl.SchoolServiceImpl;
import com.rns.fse.service.impl.SubRequestServiceImpl;
import com.rns.fse.service.impl.UserInfoServiceImpl;

import static com.rns.fse.constant.Parameter.FILTER_BY;

@CrossOrigin(origins="*")
@RestController
public class RootController {
	
	@Autowired
	private SchoolServiceImpl schoolService;

	@Autowired
	private RequestServiceImpl requestService;
	
	@Autowired
	private SubRequestServiceImpl subRequestService;
	
	@Autowired
	private OrganizationServiceImpl organizationService;
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private UserInfoServiceImpl userInfoService;
	
	@RequestMapping(value="/getAllSchoolDetails",method=RequestMethod.GET)
	public List<SchoolDetailsModel> getSchoolDetails() {
		System.out.println("Working");
		List<SchoolDetailsModel> schoolModel = schoolService.fetchSchoolDetailsService();
		return schoolModel;		
	}
	
	@RequestMapping(value="/getAllRequestDetails",method=RequestMethod.GET)
	public List<RequestModel> getRequestDetails() {
		List<RequestModel> requestModel = requestService.fetchAllRequestService();
		return requestModel;		
	}
	
	@RequestMapping(value="/getAllOrganizationDetails",method=RequestMethod.GET)
	public List<OrganizationDetailsModel> getOrgzanitaionDetails() {
		List<OrganizationDetailsModel> organizationModel = organizationService.fetchAllOrganizationService();
		return organizationModel;		
	}
	
	@RequestMapping(value="/getAllEmployeeDetails",method=RequestMethod.GET)
	public List<EmployeeDetailsModel> getEmployeeDetails() {
		List<EmployeeDetailsModel> employeeModel = employeeService.fetechAllEmployeeService();
		return employeeModel;		
	}
 
	
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public String getUserInfo(@RequestParam("param1") String userName,@RequestParam("param2") String password) {
		System.out.println("Inside the method");
		String role = userInfoService.fetchUserData(userName,password);
		return role;		
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUserDetails(@RequestBody RegisterUser registerUser) {
		String resp = userInfoService.registerUserData(registerUser);
		return resp;

	}

}
