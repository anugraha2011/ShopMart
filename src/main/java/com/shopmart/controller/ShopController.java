package com.shopmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopmart.dto.ResponseStructure;
import com.shopmart.entity.OrderInfo;
import com.shopmart.entity.Product;
import com.shopmart.entity.Review;
import com.shopmart.entity.UserInfo;
import com.shopmart.service.OrderInfoService;
import com.shopmart.service.ProductService;
import com.shopmart.service.ReviewService;
import com.shopmart.service.UserInfoService;
import com.shopmart.util.OrderHelper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/shopmart")
public class ShopController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Operation(description = "To save user info", summary = "User will be saved")
	@ApiResponses(value = @ApiResponse(description = "User registered", responseCode = "200"))
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<UserInfo>> saveUser(@RequestBody UserInfo userInfo) {
		return userInfoService.saveUser(userInfo); 
	}
	
	@Operation(description = "To loggin", summary = "User will be logged in")
	@ApiResponses(value = @ApiResponse(description = "User logged in", responseCode = "201"))
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<ResponseStructure<UserInfo>> loginUser(@PathVariable  String email,@PathVariable String password) {
		return userInfoService.loginUser(email, password);
	}
	
	@Operation(description = "To save product info", summary = "Product will be saved")
	@ApiResponses(value = @ApiResponse(description = "Product saved", responseCode = "200"))
	@PostMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product, @PathVariable int id) {
		return productService.saveProduct(product, id);
	}
	
	@Operation(description = "To save review info", summary = "Review will be saved")
	@ApiResponses(value = @ApiResponse(description = "Review saved", responseCode = "200"))
	@PostMapping("/review/{userId}/{productId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review review, @PathVariable int userId, @PathVariable int productId) {
		return reviewService.saveReview(review, userId, productId);
	}
	
	@Operation(description = "To save order info", summary = "Order will be saved")
	@ApiResponses(value = @ApiResponse(description = "Order saved", responseCode = "200"))
	@PostMapping("/order/{userId}")
	public ResponseEntity<ResponseStructure<OrderInfo>> saveOrder(@RequestBody OrderHelper orderHelper, @PathVariable int userId) {
		return orderInfoService.saveOrder(orderHelper, userId);
	}
	
	@Operation(description = "To fetch product info", summary = "Product info will be fetched")
	@ApiResponses(value = @ApiResponse(description = "Product fetched", responseCode = "200"))
	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@Operation(description = "To fetch review info", summary = "Review info will be fetched")
	@ApiResponses(value = @ApiResponse(description = "Review fetched", responseCode = "200"))
	@GetMapping("/review/{id}/{userId}")
	public ResponseEntity<ResponseStructure<Review>> getReviewById(@PathVariable int id,@PathVariable int userId) {
		return reviewService.getReviewById(id, userId);
	}
	
	@Operation(description = "To delete a product", summary = "Product will be deleted")
	@ApiResponses(value = @ApiResponse(description = "Product deleted", responseCode = "204"))
	@DeleteMapping("/product/{productId}/{userId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int productId, @PathVariable int userId) {
		return productService.deleteProduct(productId, userId);
	}
	
	@Operation(description = "To delete a review", summary = "Review will be deleted")
	@ApiResponses(value = @ApiResponse(description = "Review deleted", responseCode = "204"))
	@DeleteMapping("/review/{id}")
	public ResponseEntity<ResponseStructure<Review>> deleteReview(@PathVariable int id) {
		return reviewService.deleteReview(id);
	}
	
	@Operation(description = "To update a product", summary = "Product info will be updated")
	@ApiResponses(value = @ApiResponse(description = "Product updated", responseCode = "206"))
	@PutMapping("/product/{userId}/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable int userId, @PathVariable int productId) {
		return productService.updateProduct(product, userId, productId);
	}
	
	@Operation(description = "To fetch order info", summary = "Order info will be fetched")
	@ApiResponses(value = @ApiResponse(description = "Order fetched", responseCode = "200"))
	@GetMapping("/order/{id}/{userId}")
	public ResponseEntity<ResponseStructure<OrderInfo>> getOrderById(@PathVariable int id,@PathVariable int userId) {
		return orderInfoService.getOrderById(id, userId);
	}
}
