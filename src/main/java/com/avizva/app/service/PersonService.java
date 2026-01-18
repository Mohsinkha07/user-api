package com.avizva.app.service;


import com.avizva.app.entity.Person;
import com.avizva.app.entity.PersonDTO;
import com.avizva.app.exceptions.PersonGenderNotValid;
import com.avizva.app.exceptions.PersonMaritalStatusNotValid;
import com.avizva.app.exceptions.PersonNameCanNotBeNull;
import com.avizva.app.exceptions.PersonNotFoundException;
import com.avizva.app.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public  void addUser(Person person) {
            validatePerson(person);
          personRepository.addPerson(person.getName(),person.getGender(), person.getMaritalStatus());
    }

    private void validatePerson(Person person) {
        if (person.getName() == null || person.getName().isBlank()) {
            throw new PersonNameCanNotBeNull("Person name is mandatory");
        }

        if (person.getGender() == null) {
            throw new PersonGenderNotValid("Gender is mandatory");
        }

        if (person.getMaritalStatus() == null) {
            throw new PersonMaritalStatusNotValid("Marital status is mandatory");
        }
    }

    public PersonDTO personToDto(Person person){
        PersonDTO personDTO = new PersonDTO(person);
        return personDTO;
    }

    public List<PersonDTO> getAllUsers() {
        return personRepository.findAll()
                .stream()
                .map(person -> personToDto(person))
                .collect(Collectors.toList());
    }

    public Person getById(int id) {
        Optional<Person> person = personRepository.findById(id);

        if(person.isEmpty()){
            throw new PersonNotFoundException("No Person is present for the given id");
        }
        return person.get();
    }

    public void removeAllUser(){
        personRepository.deleteAll();
    }

    public void removeById(int id){
        Optional<Person> personToDelete = personRepository.findById(id);
        if(personToDelete.isEmpty()){
            throw new PersonNotFoundException("Person already deleted ");
        }
        personRepository.deleteById(id);
    }

    public Person updateUser(int id, Person person){
        Person personToUpdate = personRepository.findById(id).orElse(null);
        if(personToUpdate == null){
            throw new PersonNotFoundException("No Person found to update");
        }
        personToUpdate.setName(person.getName());
        personToUpdate.setGender(person.getGender());
        personToUpdate.setMaritalStatus(person.getMaritalStatus());

            return personRepository.save(personToUpdate);
    }
}
