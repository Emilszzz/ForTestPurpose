/*package com.example.demo;

import com.example.demo.Person;
import com.example.demo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

@Autowired
private PersonRepository personRepository;

@Override
public Person createPerson(Person person) {
return personRepository.save(person);
}

@Override
public Person getPerson(Long id) {

Optional<Person> persona =personRepository.findById(id);
Person persona1 = null;
if(persona.isPresent()) {
	persona1=persona.get();
}
	return persona1;
}

@Override
public Person editPerson(Person person) {
return personRepository.save(person);
}
/*
@Override
public void deletePerson(Person person) {
personRepository.delete(person);
}
*/
/*@Override
public List<Person> getAllPersons(int pageNumber, int pageSize) {
return personRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
}

@Override
public List<Person> getAllPersons() {
return personRepository.findAll();
}
}*/