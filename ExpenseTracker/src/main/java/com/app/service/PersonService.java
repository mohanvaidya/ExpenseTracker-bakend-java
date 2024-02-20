package com.app.service;

import java.util.List;

import com.app.entity.Person;
import com.app.persondto.PersonDTO;

public interface PersonService {


	PersonDTO registerNewperson(PersonDTO persondto);

	Person getpersonById(Long personId);

	String deletePersonDetails(Long personID);

	List<PersonDTO> getAllpersons();

	Person getbyEmailAndPassword(String email, String password);

	PersonDTO  updateperson(PersonDTO person, Long personId);
}
