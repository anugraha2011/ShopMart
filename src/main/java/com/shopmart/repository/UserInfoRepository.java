package com.shopmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmart.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	
	UserInfo findByEmailAndPassword(String email, String password);
	
	UserInfo findRoleByUserId(int id);
}