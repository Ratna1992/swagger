package com.ratna.mongo.boot.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TodoCollectionException.class)
	public ResponseEntity<ExceptionResponse> handleExceptions(TodoCollectionException exception,
			WebRequest webRequest) {
		ResponseEntity<ExceptionResponse> entity = getExceptionResponse(exception, HttpStatus.CONFLICT);
		return entity;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleExceptions(ConstraintViolationException exception,
			WebRequest webRequest) {
		ResponseEntity<ExceptionResponse> entity = getExceptionResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
		return entity;
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<ExceptionResponse> handleExceptions(UnexpectedTypeException exception,
			WebRequest webRequest) {
		ResponseEntity<ExceptionResponse> entity = getExceptionResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
		return entity;
	}

	private ResponseEntity<ExceptionResponse> getExceptionResponse(Exception exception, HttpStatus httpStatus) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(new Date(System.currentTimeMillis()));
		response.setMessage(exception.getMessage());
		response.setStatus(httpStatus.toString());
		ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, httpStatus);
		return entity;
	}

}
