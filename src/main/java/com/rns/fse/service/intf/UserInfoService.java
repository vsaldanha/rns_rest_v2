package com.rns.fse.service.intf;

import java.util.List;

import com.rns.fse.pojo.RegisterUser;
import com.rns.fse.pojo.UserInfoModel;

public interface UserInfoService {

	public String fetchUserData(String userName, String passsword);
	public String registerUserData(RegisterUser registerUser);
}
