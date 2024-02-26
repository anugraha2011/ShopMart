package com.shopmart.util;

import java.util.List;

import com.shopmart.entity.OrderInfo;

public class OrderHelper {
	private OrderInfo orderInfo;
	private List<Integer> productIds;

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}
	
	
	
	
}
