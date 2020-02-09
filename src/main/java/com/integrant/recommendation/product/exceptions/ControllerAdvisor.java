package com.integrant.recommendation.product.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.integrant.recommendation.product.model.RecommendationErrorResponse;


/**
 * The Class ControllerAdvisor.
 */
@ControllerAdvice
public class ControllerAdvisor {

	/**
	 * Handle bad request exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<RecommendationErrorResponse> handleBadRequestException(
			BadRequestException ex, WebRequest request) {

		RecommendationErrorResponse errors = new RecommendationErrorResponse(LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), ex.getMessage());


		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle message not exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleMessageNotException(Exception ex, WebRequest request) {

		RecommendationErrorResponse error = new RecommendationErrorResponse(LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	/**
	 * Handle message not exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMessageNotException(MethodArgumentNotValidException ex, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		
		List<FieldError> fieldErrors = result.getFieldErrors();

		RecommendationErrorResponse error = new RecommendationErrorResponse(LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), fieldErrors.get(0).getDefaultMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
