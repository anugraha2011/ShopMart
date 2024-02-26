package com.shopmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopmart.dao.UserInfoDao;
import com.shopmart.dto.ResponseStructure;
import com.shopmart.entity.UserInfo;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	public ResponseEntity<ResponseStructure<UserInfo>> saveUser(UserInfo userInfo){
		ResponseStructure<UserInfo> structure=new ResponseStructure<UserInfo>();
		
		UserInfo recievedUser=userInfoDao.saveUser(userInfo);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("User record saved");
		structure.setData(recievedUser);
		
		return new ResponseEntity<ResponseStructure<UserInfo>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<UserInfo>> loginUser(String email, String password) {
		ResponseStructure<UserInfo> structure=new ResponseStructure<UserInfo>();
		
		UserInfo recievedUser=userInfoDao.loginUser(email, password);
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("User successfully logged in");
		structure.setData(recievedUser);
		
		return new ResponseEntity<ResponseStructure<UserInfo>>(structure,HttpStatus.OK);
	}
}
