package com.shopmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopmart.dao.OrderInfoDao;
import com.shopmart.dto.ResponseStructure;
import com.shopmart.entity.OrderInfo;
import com.shopmart.util.OrderHelper;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoDao orderInfoDao ;
	
	public ResponseEntity<ResponseStructure<OrderInfo>> saveOrder(OrderHelper orderHelper, int userId) {
		
		ResponseStructure<OrderInfo> structure=new ResponseStructure<OrderInfo>();
		
		OrderInfo recievedOrder=orderInfoDao.saveOrderInfo(orderHelper, userId);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Order saved");
		structure.setData(recievedOrder);
		
		return new ResponseEntity<ResponseStructure<OrderInfo>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<OrderInfo>> getOrderById(int id, int userId) {

		ResponseStructure<OrderInfo> structure=new ResponseStructure<OrderInfo>();
		
		OrderInfo recievedOrder=orderInfoDao.getOrderInfo(id, userId);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Order fetched");
		structure.setData(recievedOrder);
		
		return new ResponseEntity<ResponseStructure<OrderInfo>>(structure,HttpStatus.CREATED);
	
	}

}
