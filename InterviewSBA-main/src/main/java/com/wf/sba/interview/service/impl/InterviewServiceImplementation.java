package com.wf.sba.interview.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.sba.interview.dto.Interviewdto;
import com.wf.sba.interview.entity.Interview;
import com.wf.sba.interview.exception.RecordNotFoundException;
import com.wf.sba.interview.repository.IInterviewRepository;
import com.wf.sba.interview.service.InterviewService;

@Service
public class InterviewServiceImplementation implements InterviewService {

	@Autowired
	IInterviewRepository repository;


	@Override
	public Interviewdto createInterview(Interviewdto interview) {
		Interview InterviewEntity = repository.save(dtoToEntity(interview));
		return convertToDTO(InterviewEntity);
	}


	@Override
	public Interviewdto deleteInterview(Long id) {
		Optional<Interview> User = repository.findById(id);
		if (User.isPresent()) {
			repository.deleteById(id);
			return convertToDTO(User.get());
		} else {
			throw new RecordNotFoundException("No interview record exist for given id", String.valueOf(id));
		}
	}

	@Override
	public List<Interviewdto> getAllInterviews() {
List<Interview> interviewList = repository.findAll();
		
		if(interviewList.size()!=0)
		return convertToDTO(interviewList);
		else
			throw new RecordNotFoundException("Number of interview detail present", String.valueOf(interviewList.size()));
	}

	@Override
	public Interviewdto getInterviewById(Long id) {
		Optional<Interview> interview = repository.findById(id);
		if (interview.isPresent()) {
			return convertToDTO(interview.get());
		} else {
			throw new RecordNotFoundException("No interview record exist for given id", String.valueOf(id));
		}
	}

	@Override
	public List<Interviewdto> getInterviewByInterViewerName(String interviewerName) {
		List<Interview> interview = repository.getInterviewByInterviewerName(interviewerName);
		if (interview.size()>0) {
			return convertToDTO(interview);
		} else {
			throw new RecordNotFoundException("No interview record exist for given interviewer name", interviewerName);
		}
	}

	@Override
	public List<Interviewdto> getInterviewByInterViewName(String interviewName) {
		List<Interview> interview = repository.getInterviewByInterviewName(interviewName);
		if (interview.size()>0) {
			return convertToDTO(interview);
		} else {
			throw new RecordNotFoundException("No interview record exist for given interview name", interviewName);
		}
	}

	@Override
	public Interviewdto updateInterviewStatus(Long id, String status) {
		Optional<Interview> interview = repository.findById(id);
		if (interview.isPresent()) {
			Interview intUp = interview.get();
			intUp.setInterviewStatus(status);
			intUp = repository.save(intUp);
			return convertToDTO(intUp);
		} else {
			throw new RecordNotFoundException("No interview record exist for given id", String.valueOf(id));
		}
	}

	private Interviewdto convertToDTO(Interview interview) {
		Interviewdto InterviewDTO = new Interviewdto();
		InterviewDTO.setId(interview.getId());
		InterviewDTO.setInterviewerName(interview.getInterviewerName());
		InterviewDTO.setInterviewName(interview.getInterviewName());
		InterviewDTO.setUserSkills(interview.getUserSkills());
		InterviewDTO.setInterviewStatus(interview.getInterviewStatus());
		InterviewDTO.setRemarks(interview.getRemarks());
		InterviewDTO.setTime(interview.getTime());
		InterviewDTO.setDate(interview.getDate());
		return InterviewDTO;
	}

	private List<Interviewdto> convertToDTO(List<Interview> user) {
		return user.stream().map(x -> convertToDTO(x)).collect(Collectors.toList());
	}

	private Interview dtoToEntity(Interviewdto dto) {
		Interview InterviewEntity = new Interview();
		InterviewEntity.setInterviewerName(dto.getInterviewerName());
		InterviewEntity.setInterviewName(dto.getInterviewName());
		InterviewEntity.setUserSkills(dto.getUserSkills());
		InterviewEntity.setInterviewStatus(dto.getInterviewStatus());
		InterviewEntity.setRemarks(dto.getRemarks());
		InterviewEntity.setTime(LocalTime.now());
		InterviewEntity.setDate(LocalDate.now());
		return InterviewEntity;
	}

}
