package com.wf.sba.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.sba.interview.dto.Attenddto;
import com.wf.sba.interview.service.AttendService;

@RestController
@RequestMapping("/attend")
public class AttendController {
	
	@Autowired
	AttendService attendenceService;
	
	@GetMapping("/")
	public ResponseEntity<List<Attenddto>> getAllAttendees() {
		List<Attenddto> list = attendenceService.getAllAttendees();
		return new ResponseEntity<List<Attenddto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/{interviewId}/{userID}")
	public ResponseEntity<Attenddto> addInterview(@PathVariable("interviewId") Long interviewId,@PathVariable("userID") Long userId) {
		Attenddto dto = attendenceService.addAttendee(interviewId, userId);
		return new ResponseEntity<Attenddto>(dto, new HttpHeaders(), HttpStatus.OK);

	}
	
	@GetMapping("/count")
	public ResponseEntity<String> getTotalInterviews() {
		List<Attenddto> list = attendenceService.getAllAttendees();
		return new ResponseEntity<String>("Number of interviews attended by all users - "+list.size(), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/Interview/{id}")
	public ResponseEntity<List<Attenddto>> getAttendeeByInterviewId(@PathVariable("id") Long id) {
		List<Attenddto> dto = attendenceService.findAttendeByInterviewID(id);
		return new ResponseEntity<List<Attenddto>>(dto, new HttpHeaders(), HttpStatus.OK);
	}
	

}
