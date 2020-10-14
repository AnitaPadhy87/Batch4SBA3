package com.wf.sba.interview.exception;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ExceptionResponse {

	private Date timestamp;
	private List<String> message;
	private String details;

	public ExceptionResponse(Date timestamp, List<String> message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}