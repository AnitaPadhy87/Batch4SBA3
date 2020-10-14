package com.wf.sba.interview.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice 
public class GlobalHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(RecordNotFoundException ex,
			WebRequest request) {
		List<String> message = new ArrayList<String>();
		message.add(ex.getMessage());
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), message, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AttendeeAlreadyExistsException.class)
	public final ResponseEntity<ExceptionResponse> handleUserExistsException(AttendeeAlreadyExistsException ex,
			WebRequest request) {
		List<String> message = new ArrayList<String>();
		message.add(ex.getMessage());
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), message, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> message = new ArrayList<String>();
		message.add(ex.getMessage());
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), message, request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       
        List<String> message = new ArrayList<String>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {   
        	message.add(error.getDefaultMessage());           
        }
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}