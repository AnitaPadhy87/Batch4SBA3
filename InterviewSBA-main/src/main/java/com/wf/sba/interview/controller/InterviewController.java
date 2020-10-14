package com.wf.sba.interview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.sba.interview.dto.Interviewdto;
import com.wf.sba.interview.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	InterviewService interviewService;

	@GetMapping("/")
	public ResponseEntity<List<Interviewdto>> getAllInterview() {
		List<Interviewdto> list = interviewService.getAllInterviews();
		return new ResponseEntity<List<Interviewdto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Interviewdto> getInterviewById(@PathVariable("id") Long id) {
		Interviewdto dto = interviewService.getInterviewById(id);
		return new ResponseEntity<Interviewdto>(dto, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/interviewerName/{name}")
	public ResponseEntity<List<Interviewdto>> getInterviewByInterviewerName(@PathVariable("name") String name) {
		List<Interviewdto> dto = interviewService.getInterviewByInterViewerName(name);
		return new ResponseEntity<List<Interviewdto>>(dto, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/interviewName/{name}")
	public ResponseEntity<List<Interviewdto>> getInterviewByInterviewName(@PathVariable("name") String name) {
		List<Interviewdto> dto = interviewService.getInterviewByInterViewName(name);
		return new ResponseEntity<List<Interviewdto>>(dto, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Interviewdto> addInterview(@Valid @RequestBody Interviewdto interview) {
		Interviewdto dto = interviewService.createInterview(interview);
		return new ResponseEntity<Interviewdto>(dto, new HttpHeaders(), HttpStatus.OK);

	}

	
	@PutMapping("/UpdateStatus/{id}/{Status}")
	public ResponseEntity<Interviewdto> updateInterviewStatus(@PathVariable("id") Long id,
			@PathVariable("Status") String status) {
		Interviewdto dto = interviewService.updateInterviewStatus(id, status);
		return new ResponseEntity<Interviewdto>(dto, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Interviewdto> deleteInterview(@PathVariable("id") Long id) {
		Interviewdto dto = interviewService.deleteInterview(id);
		return new ResponseEntity<Interviewdto>(dto, new HttpHeaders(), HttpStatus.OK);
	}
}
