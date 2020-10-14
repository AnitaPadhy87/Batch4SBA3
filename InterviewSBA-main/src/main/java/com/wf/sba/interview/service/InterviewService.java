package com.wf.sba.interview.service;

import java.util.List;

import com.wf.sba.interview.dto.Interviewdto;

public interface InterviewService {
	
	public abstract Interviewdto createInterview(Interviewdto User);

	public abstract Interviewdto deleteInterview(Long id);

	public abstract List<Interviewdto> getAllInterviews();

	public abstract Interviewdto getInterviewById(Long id);
	
	public abstract List<Interviewdto> getInterviewByInterViewerName(String name);
	
	public abstract List<Interviewdto> getInterviewByInterViewName(String name);
	
	public abstract Interviewdto updateInterviewStatus(Long id,String status);
}
