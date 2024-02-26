package com.shopmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

//	List<Product> findAllById(List<Integer> productList);
	
}
