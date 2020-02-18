package com.integrant.recommendation.product.exceptions;

public class ResourceNotFoundException extends RecommendationException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(404, message);
	}

}
