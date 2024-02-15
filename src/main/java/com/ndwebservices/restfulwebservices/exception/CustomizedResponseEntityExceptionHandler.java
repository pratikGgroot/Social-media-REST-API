package com.ndwebservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ndwebservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMsg> handleAllException(Exception ex, WebRequest request) throws Exception {

	ErrorMsg errmsg = new ErrorMsg(LocalDateTime.now(),
			ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<ErrorMsg>(errmsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorMsg> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

	ErrorMsg errmsg = new ErrorMsg(LocalDateTime.now(),
			ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<ErrorMsg>(errmsg, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorMsg errmsg = new ErrorMsg(LocalDateTime.now(),
				ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		
		return new ResponseEntity(errmsg, HttpStatus.BAD_REQUEST);
	}

}
