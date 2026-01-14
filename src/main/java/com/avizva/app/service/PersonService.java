package com.avizva.app.service;

import com.avizva.app.entity.Person;
import com.avizva.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public  void addUser(Person person) {
          personRepository.addPerson(person.getName(), person.getMaritalStatus());
    }

    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    public Person getByUserId(int id) {
    return personRepository.findById(id);
    }

    public void removeAllUser(){
         personRepository.deleteAll();
    }

    public void removeById(int id){
        personRepository.deleteById(id);
    }

    public Person updateUser(int id, Person person){
        Person personToUpdate = personRepository.findById(id);
        if (personToUpdate == null) {
            throw new NullPointerException("User not found");
        }
        personToUpdate.setName(person.getName());
        personToUpdate.setGender(person.getGender());
        personToUpdate.setMaritalStatus(person.getMaritalStatus());

            return personRepository.save(personToUpdate);

    }
}
