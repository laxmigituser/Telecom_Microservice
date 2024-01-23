package com.pkg.util;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pkg.exception.CustomPlanException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@ExceptionHandler(CustomPlanException.class)
	public ResponseEntity<ApiResponse> resourcenotfoundException(CustomPlanException ex) {
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setStatus(HttpStatus.METHOD_FAILURE);
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.METHOD_FAILURE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> generalExceptionHandler(Exception exception) {
		logger.info(exception.getMessage());
		logger.info(exception.getStackTrace().toString());
		ApiResponse response = new ApiResponse();
		response.setMessage(exception.getMessage());
		response.setStatus(HttpStatus.METHOD_FAILURE);
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.METHOD_FAILURE);
	}

//handler for methodargumentnotvalidexception and ConstraintsViolationException
	@ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
	public ResponseEntity<ApiResponse> exceptionHandler(Exception ex) {

		logger.error(ex.getMessage(), ex);

		String errorMessage;

		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException mex = (MethodArgumentNotValidException) ex;
			errorMessage =mex.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException cex = (ConstraintViolationException) ex;
			errorMessage = cex.getConstraintViolations().stream().map(x -> x.getMessage())
					.collect(Collectors.joining(", "));
		}
		ApiResponse response = new ApiResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.METHOD_FAILURE);
		response.setSuccess(true);

		return new ResponseEntity<>(response, HttpStatus.METHOD_FAILURE);
	}
}
