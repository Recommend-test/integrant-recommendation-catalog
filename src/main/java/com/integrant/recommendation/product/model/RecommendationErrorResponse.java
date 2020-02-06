package com.integrant.recommendation.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class RecommendationErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;

	public RecommendationErrorResponse(LocalDateTime timestamp, int status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;

	}
	public String getError() {
		return error;
	}
}

