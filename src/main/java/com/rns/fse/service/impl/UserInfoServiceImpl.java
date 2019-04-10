package com.rns.fse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.dao.UserInfoDao;
import com.rns.fse.pojo.RegisterUser;
import com.rns.fse.service.intf.UserInfoService;

@Component
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public String fetchUserData(String UserName, String password) {
		String role = userInfoDao.fetchUserData(UserName,password);
		return role;
	}

	@Override
	public String registerUserData(RegisterUser registerUser) {
		String role = userInfoDao.registerUserData(registerUser);
		return null;
	}

}
