package com.avizva.app.service;

import com.avizva.app.entity.Person;
import com.avizva.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Person addUser(Person person) {
         return userRepository.addUser(person);
    }

    public List<Person> getUsers() {
        return userRepository.findAll();
    }

    public Person getByUserId(int id) {
    return userRepository.findById(id);
    }

    public void removeAllUser(){
         userRepository.deleteAll();
    }

    public void removeById(int id){
        userRepository.deleteById(id);
    }

    public Person updateUser(int id, Person person){
        Person personToUpdate = userRepository.findById(id);
        if (personToUpdate == null) {
            throw new NullPointerException("User not found");
        }
        personToUpdate.setName(person.getName());
        personToUpdate.setGender(person.getGender());
        personToUpdate.setMaritalStatus(person.getMaritalStatus());

            return userRepository.save(personToUpdate);

    }
}
