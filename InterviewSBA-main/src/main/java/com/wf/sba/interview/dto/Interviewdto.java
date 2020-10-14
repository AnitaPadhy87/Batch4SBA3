package com.wf.sba.interview.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Interviewdto {
	
	private long id;

	@NotEmpty(message = "Please enter Interviewer Name")
	@Size(min = 5, max = 30, message = "Interviewer Name should be minimun 5 charecters and maximum 30 characters")
	private String interviewerName;

	@NotEmpty(message = "Please enter Interview Name")
	@Size(min = 3, max = 30, message = "Interview Name should be minimun 3 charecters and maximum 30 characters")
	private String interviewName;

	@NotEmpty(message = "Please enter User skills")
	@Size(min = 5, max = 30, message = "User Skills should be minimun 5 charecters and maximum 30 characters")
	private String userSkills;

	private LocalTime time;

	private LocalDate date;

	@NotEmpty(message = "Please enter Interview Status")
	@Size(min = 5, max = 30, message = "Interview Status should be minimun 5 charecters and maximum 100 characters")
	private String interviewStatus;

	@NotEmpty(message = "Please enter Remarks")
	@Size(min = 5, max = 30, message = "Remarks should be minimun 5 charecters and maximum 100 characters")
	private String remarks;
	
	
}
