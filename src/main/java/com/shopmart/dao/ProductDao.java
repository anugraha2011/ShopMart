package com.shopmart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Product;
import com.shopmart.entity.UserInfo;
import com.shopmart.exception.IdNotFoundException;
import com.shopmart.repository.ProductRepository;
import com.shopmart.repository.UserInfoRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	public Product saveProduct(Product product, int id) {
		
		UserInfo userInfo = userInfoRepository.findRoleByUserId(id);
		
		if(userInfo.getRole().equalsIgnoreCase("merchant")) {
			product.setUser(userInfo);
			return productRepository.save(product);			
		} else {
			throw new IdNotFoundException();
		}
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product deleteProduct(int productId, int userId) {
		Optional<Product> opt = productRepository.findById(productId);
		Optional<UserInfo> users = userInfoRepository.findById(userId);
		if(users.get().getRole().equalsIgnoreCase("Merchant"))
		{
		if (opt.isPresent()) {
			productRepository.delete(opt.get());
			return opt.get();
			
		} else {
			throw new NullPointerException();
		}
		}
		else {
			throw new IdNotFoundException();
		}
	}

	public Product updateProduct(Product product, int userId, int productId) {
		
		UserInfo userInfo = userInfoRepository.findRoleByUserId(userId);
		
		if(userInfo.getRole().equalsIgnoreCase("merchant")) {
			Optional<Product> opt=productRepository.findById(productId);
				opt.get().setProductName(product.getProductName());
				opt.get().setPrice(product.getPrice());
				
				return productRepository.save(opt.get());			
		} else {
			throw new IdNotFoundException();
		}
	}
}
