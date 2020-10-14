package com.wf.sba.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AttendeeAlreadyExistsException extends RuntimeException {

	public AttendeeAlreadyExistsException(String exceptionDetail, String value) {
		super(exceptionDetail + " - " + value);
	}

}