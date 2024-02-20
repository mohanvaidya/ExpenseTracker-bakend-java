package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.apiresponse.ApiResponse;
import com.app.persondto.PersonDTO;
import com.app.service.PersonService;

@RestController
@RequestMapping("api/person")
public class personController {

	@Autowired
	private PersonService service;

	public personController() {
		// TODO Auto-generated constructor stub
		System.out.println("inside a person controller");
	}

	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody PersonDTO personDto) {
		PersonDTO registerpersonDto = this.service.registerNewperson(personDto);
		return new ResponseEntity<>(registerpersonDto, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public List<PersonDTO> getAllUsers() {
		System.out.println("---Users List---");
		return service.getAllpersons();
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updatPersonDetails(@RequestBody PersonDTO persondto, @PathVariable long userid) {
		PersonDTO updatepersondetails = this.service.updateperson(persondto, userid);
		return ResponseEntity.ok(updatepersondetails);
	}

	@DeleteMapping("/{userID}")
	public ApiResponse deletePersondetails(@PathVariable Long userID) {
		System.out.println("delete user details" + userID);
		return new ApiResponse(service.deletePersonDetails(userID), true);

	}

}
