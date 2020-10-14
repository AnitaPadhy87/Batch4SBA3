package com.wf.sba.interview.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Userdto {
	
	private long id;
	
	@NotEmpty(message = "Please enter FirstName")
	@Size(min = 5, max = 30,message = "First Name should be minimun 5 charecters and maximum 30 characters")
	private String firstName;

	@NotEmpty(message = "Please enter LastName")
	@Size(min = 3, max = 25,message = "Last Name should be minimun 3 charecters and maximum 25 characters")
	private String lastName;

	@NotEmpty(message = "Please enter the email")
	@Email(message = "Please enter valid email address")
	private String email;

	@NotNull(message = "Please provide mobile number")
	@Length(min = 10, max = 10,message = "Mobile number should be 10 digits")
	private String mobile;
	
}