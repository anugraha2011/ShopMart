package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopmart.dao.ProductDao;
import com.shopmart.dto.ResponseStructure;
import com.shopmart.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int id){
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		
		Product recievedProduct=productDao.saveProduct(product, id);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Product saved");
		structure.setData(recievedProduct);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		
		List<Product> recievedProduct=productDao.getAllProduct();
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Products found");
		structure.setData(recievedProduct);
		
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId, int userId) {
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		
		Product recievedProduct=productDao.deleteProduct(productId, userId);
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Product deleted successfully");
		structure.setData(recievedProduct);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int userId, int productId) {
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		
		Product recievedProduct=productDao.updateProduct(product, userId, productId);
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Product updated successfully");
		structure.setData(recievedProduct);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	}
}
