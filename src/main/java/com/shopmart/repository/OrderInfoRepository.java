package com.shopmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmart.entity.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer>{

}
