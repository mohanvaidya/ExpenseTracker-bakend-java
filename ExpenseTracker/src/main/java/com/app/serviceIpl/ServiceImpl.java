package com.app.serviceIpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Person;
import com.app.exception.ResourceNotFoundException;
import com.app.persondto.PersonDTO;
import com.app.repository.PersonRepo;
import com.app.service.PersonService;

@Service
@Transactional
public class ServiceImpl implements PersonService {

	@Autowired
	private PersonRepo repo;

	@Autowired
	private ModelMapper mapper;


	@Override
	public PersonDTO registerNewperson(PersonDTO persondto) {
		Person person = this.mapper.map(persondto, Person.class);
		Person savePerson = this.repo.save(person);
		return this.mapper.map(savePerson, PersonDTO.class);
	}

	@Override
	public Person getpersonById(Long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deletePersonDetails(Long userID) {
		String mesg = "User id invalid , can't delete user details ";
		if (repo.existsById(userID)) {
			repo.deleteById(userID);
			mesg = "User with ID=" + userID + "  deleted !";
		}
		return mesg;
	}

	@Override
	public List<PersonDTO> getAllpersons() {

		List<Person> person = this.repo.findAll();

		List<PersonDTO> personDtos = person.stream().map(user -> this.mapper.map(user, PersonDTO.class))
				.collect(Collectors.toList());
		return personDtos;
	}

	@Override
	public Person getbyEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO updateperson(PersonDTO persondto, Long userId) {
		Person person = repo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Not a Valid User ", "id", userId));
		person.setFirstName(persondto.getFirstName());
		person.setLastName(persondto.getLastName());
		person.setEmail(persondto.getEmail());
		person.setPhoneNo(persondto.getPhoneNo());
		Person updatedperson = repo.save(person);
		return this.mapper.map(updatedperson, PersonDTO.class);
	}

}
