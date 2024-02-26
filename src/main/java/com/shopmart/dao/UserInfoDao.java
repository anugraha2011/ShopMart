package com.shopmart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.UserInfo;
import com.shopmart.repository.UserInfoRepository;

@Repository
public class UserInfoDao {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo saveUser(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}
	
	public UserInfo loginUser(String email, String password) {
		
		UserInfo userInfo= userInfoRepository.findByEmailAndPassword(email, password);
		return userInfo;
	}
}
