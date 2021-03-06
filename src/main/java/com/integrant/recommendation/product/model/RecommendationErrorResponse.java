package com.integrant.recommendation.product.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RecommendationErrorResponse.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendationErrorResponse {

	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	
	/** The status. */
	private int status;
	
	/** The error. */
	private String error;
}

