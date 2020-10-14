package com.wf.sba.interview.service;

import java.util.List;

import com.wf.sba.interview.dto.Attenddto;

public interface AttendService {

	public abstract Attenddto addAttendee(Long interviewId,Long userId);
	
	public abstract List<Attenddto> getAllAttendees();
	
	public abstract List<Attenddto> findAttendeByInterviewID(Long interviewId);
	
}
