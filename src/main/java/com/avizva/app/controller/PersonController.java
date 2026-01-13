package com.avizva.app.controller;

import com.avizva.app.entity.Person;
import com.avizva.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public List<Person> getAllUsers() {
        return personService.getUsers();
    }

    @GetMapping("/id/{id}")
    public Person getById(@PathVariable int id){
        return personService.getByUserId(id);
    }

    @GetMapping
    public String Test(){
        return "Ok";
    }

    @PostMapping
    public Person addUser(@RequestBody Person person){
        return personService.addUser(person);
    }

    @DeleteMapping("/all")
    public void removeUser(){
        personService.removeAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public void removeByID(@PathVariable int id){
        personService.removeById(id);
    }

    @PutMapping("/put/{id}")
    public Person updateUser(@PathVariable int id, @RequestBody Person person){
        return  personService.updateUser(id, person);
    }


}
