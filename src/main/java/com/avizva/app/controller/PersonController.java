package com.avizva.app.controller;

import com.avizva.app.entity.Person;
import com.avizva.app.entity.PersonDTO;
import com.avizva.app.exceptions.PersonNotFoundException;
import com.avizva.app.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PersonDTO>> getAll() {
        return ResponseEntity.ok(personService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable int id) {
        Person person = personService.getById(id);
        return ResponseEntity.ok(new PersonDTO(person));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Person person) {
        personService.addUser(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person) {
        return ResponseEntity.ok(personService.updateUser(id, person));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        personService.removeAllUser();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        personService.removeById(id);
        return ResponseEntity.noContent().build();
    }


}

