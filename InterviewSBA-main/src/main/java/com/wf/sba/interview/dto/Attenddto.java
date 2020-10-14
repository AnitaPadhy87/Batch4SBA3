package com.wf.sba.interview.dto;

import com.wf.sba.interview.entity.Interview;
import com.wf.sba.interview.entity.User;

import lombok.Data;

@Data
public class Attenddto {
	
	private long id;
	private User user;
	private Interview interview;
}
