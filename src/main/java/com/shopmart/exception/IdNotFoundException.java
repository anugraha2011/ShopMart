package com.shopmart.exception;

public class IdNotFoundException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "ID does not exist";
	}

}
