package com.rns.fse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rns.fse.entities.UserInfo;
import com.rns.fse.repository.UserInfoRepo;

@Component
public class UserInfoDao {
	
	@Autowired
	UserInfoRepo userInfoRepo;

	public String fetchUserData(String userName, String password) {
		Object role = userInfoRepo.fetchUserInfo(userName, password);
		System.out.println("ROle is:"+role.toString());
		return role.toString();
	}

}
