package com.shopmart.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopmart.dao.ReviewDao;
import com.shopmart.dto.ResponseStructure;
import com.shopmart.entity.Review;
import com.shopmart.exception.IdNotFoundException;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review, int userId, int productId) {
		ResponseStructure<Review> structure=new ResponseStructure<Review>();
		
		Review recievedReview=reviewDao.saveReview(review, userId, productId);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Review saved");
		structure.setData(recievedReview);
		
		return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Review>> getReviewById(int id, int userId) {
		ResponseStructure<Review> structure=new ResponseStructure<Review>();
		
		Review recievedReview=reviewDao.getReviewById(id, userId);
		
		if(recievedReview!=null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Review found");
			structure.setData(recievedReview);	
			
			return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Review>> deleteReview(int id) {
		ResponseStructure<Review> structure=new ResponseStructure<Review>();
		
		Review recievedReview=reviewDao.deleteReview(id);
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Review deleted successfully");
		structure.setData(recievedReview);
		
		return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.OK);
	}

}
