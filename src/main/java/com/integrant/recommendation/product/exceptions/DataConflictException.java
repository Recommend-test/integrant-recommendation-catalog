package com.integrant.recommendation.product.exceptions;

/**
 * The Class DataConflictException.
 */
public class DataConflictException extends RecommendationException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1;

	/**
	 * Instantiates a new data conflict exception.
	 *
	 * @param message the message
	 */
	public DataConflictException(String message) {
		super(409, message);
	}
}
