package com.shopmart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.OrderInfo;
import com.shopmart.entity.Product;
import com.shopmart.entity.Review;
import com.shopmart.entity.UserInfo;
import com.shopmart.exception.IdNotFoundException;
import com.shopmart.repository.OrderInfoRepository;
import com.shopmart.repository.ProductRepository;
import com.shopmart.repository.UserInfoRepository;
import com.shopmart.util.OrderHelper;

@Repository
public class OrderInfoDao {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderInfoRepository orderInfoRepository;

	public OrderInfo saveOrderInfo(OrderHelper orderHelper, int userId) {

		UserInfo userInfo = userInfoRepository.findRoleByUserId(userId);

		OrderInfo orderInfo = orderHelper.getOrderInfo();
		List<Integer> productList = orderHelper.getProductIds();
		List<Product> list = productRepository.findAllById(productList);
		if (userInfo.getRole().equalsIgnoreCase("customer")) {
			if (list != null) {
				orderHelper.getOrderInfo().setProducts(list);
				orderHelper.getOrderInfo().setUser(userInfo);
				return orderInfoRepository.save(orderInfo);
			} else {
				throw new NullPointerException();
			}

		} else {
			throw new IdNotFoundException();
		}
	}

	public OrderInfo getOrderInfo(int id, int userId) {
		
		UserInfo userInfo = userInfoRepository.findRoleByUserId(userId);

		if (userInfo.getRole().equalsIgnoreCase("customer")) {
			Optional<OrderInfo> opt = orderInfoRepository.findById(id);

			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

}
