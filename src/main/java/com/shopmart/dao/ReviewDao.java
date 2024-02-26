package com.shopmart.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Product;
import com.shopmart.entity.Review;
import com.shopmart.entity.UserInfo;
import com.shopmart.exception.IdNotFoundException;
import com.shopmart.repository.ProductRepository;
import com.shopmart.repository.ReviewRepository;
import com.shopmart.repository.UserInfoRepository;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ProductRepository productRepository;

	public Review saveReview(Review review, int userId, int productId) {

		UserInfo userInfo = userInfoRepository.findRoleByUserId(userId);

		if (userInfo.getRole().equalsIgnoreCase("customer")) {
			Optional<Product> opt = productRepository.findById(productId);
			if (opt.isPresent()) {
				review.setProduct(opt.get());
				return reviewRepository.save(review);
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

	public Review getReviewById(int id, int userId) {
		UserInfo userInfo = userInfoRepository.findRoleByUserId(userId);

		if (userInfo.getRole().equalsIgnoreCase("merchant")) {
			Optional<Review> opt = reviewRepository.findById(id);

			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

	public Review deleteReview(int id) {
		Optional<Review> opt = reviewRepository.findById(id);

		if (opt.isPresent()) {
			reviewRepository.delete(opt.get());
			return opt.get();
			
		} else {
			throw new NullPointerException();
		}
	}

}
