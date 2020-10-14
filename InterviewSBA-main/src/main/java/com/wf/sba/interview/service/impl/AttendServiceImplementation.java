package com.wf.sba.interview.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.sba.interview.dto.Attenddto;
import com.wf.sba.interview.entity.Attend;
import com.wf.sba.interview.entity.Interview;
import com.wf.sba.interview.entity.User;
import com.wf.sba.interview.exception.AttendeeAlreadyExistsException;
import com.wf.sba.interview.exception.RecordNotFoundException;
import com.wf.sba.interview.repository.IAttendRepository;
import com.wf.sba.interview.repository.IInterviewRepository;
import com.wf.sba.interview.repository.IUserRepository;
import com.wf.sba.interview.service.AttendService;

@Service
public class AttendServiceImplementation implements AttendService {

	@Autowired
	IAttendRepository attendeeRepository;

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IInterviewRepository interviewRepository;


	@Override
	public List<Attenddto> getAllAttendees() {
		List<Attend> attendeeList = attendeeRepository.findAll();
		if(attendeeList.size()>0)
			return convertToAttendDTO(attendeeList);
		else 
			throw new RecordNotFoundException("No of attendee for any interview", String.valueOf(attendeeList.size()));
	}

	@Override
	public Attenddto addAttendee(Long interviewId, Long userId) {

		Optional<User> user = userRepository.findById(userId);
		Optional<Interview> interview = interviewRepository.findById(interviewId);

		if (user.isPresent() && interview.isPresent()) {

			Attend attendee = new Attend();
			attendee.setInterview(interview.get());
			attendee.setUser(user.get());

			Optional<Attend> att = attendeeRepository.findAttendeByUserIDIntervciewID(userId, interviewId);

			if (!att.isPresent()) {
				Attend attendeeEntity = attendeeRepository.save(attendee);
				return convertToAttendDTO(attendeeEntity);
			} else {
				throw new AttendeeAlreadyExistsException("User has already attended the interview",
						"Inertview ID:-" + interviewId + ", User ID:-" + userId);
			}

		} else {
			throw new RecordNotFoundException(
					"Interview/User details for given InterviewId/UserId not present. Please enter correct details",
					"Inertview ID:-" + interviewId + ", User ID:-" + userId);
		}

	}
	
	@Override
	public List<Attenddto> findAttendeByInterviewID(Long interviewId) {
		List<Attend> attendees = attendeeRepository.findAttendeByInterviewID(interviewId);
		if (attendees.size() > 0) {
			return convertToAttendDTO(attendees);
		} else {
			throw new RecordNotFoundException("No attendee record present for given interview id:-",
					String.valueOf(interviewId));
		}
	}

	private Attenddto convertToAttendDTO(Attend attendee) {
		Attenddto attendeeDto = new Attenddto();
		attendeeDto.setId(attendee.getId());
		attendeeDto.setUser(attendee.getUser());
		attendeeDto.setInterview(attendee.getInterview());
		return attendeeDto;
	}

	private List<Attenddto> convertToAttendDTO(List<Attend> attendee) {
		return attendee.stream().map(x -> convertToAttendDTO(x)).collect(Collectors.toList());
	}


}
