package com.servlet.service;

import java.util.HashMap;

import com.servlet.model.LoginModel;



public class LoginService {
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("ezhil", "Ezhilarasi");
		users.put("sandy", "Sandhiya");
		
	}
	public boolean authenticate(String userId, String password){
		if(password == null || password.trim()== ""){
			return false;
		}
		return true;
	}
	
	public LoginModel getUserDetails(String userId){
		LoginModel loginModel = new LoginModel();
		loginModel.setUserName(users.get(userId));
		loginModel.setUserId(userId);
		return loginModel;
		
	}
	

}
