package com.integrant.recommendation.product.exceptions;

public class DataConflictException extends RecommendationException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1;

	/**
	 * Instantiates a new bad request exception.
	 * @param message the message
	 */
	public DataConflictException(String message) {
		super(409, message);
	}
}
