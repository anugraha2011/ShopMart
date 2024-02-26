package com.shopmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmart.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	

}
