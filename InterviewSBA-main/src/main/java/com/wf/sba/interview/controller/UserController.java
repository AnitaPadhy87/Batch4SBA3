package com.wf.sba.interview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.sba.interview.dto.Userdto;
import com.wf.sba.interview.service.UserService;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<Userdto>> getAllUser() {
		List<Userdto> list = userService.getAllUser();
		return new ResponseEntity<List<Userdto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Userdto> getUserById(@PathVariable("id") Long id) {

		Userdto dto = userService.getUserById(id);

		return new ResponseEntity<Userdto>(dto, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<Userdto> addUser(@Valid @RequestBody Userdto User) {
		Userdto dto = userService.createUser(User);
		return new ResponseEntity<Userdto>(dto, new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Userdto> deleteUser(@PathVariable("id") Long id) {
		Userdto dto = userService.deleteUser(id);
		return new ResponseEntity<Userdto>(dto, new HttpHeaders(), HttpStatus.OK);
	}

}
