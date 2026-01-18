package com.avizva.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> prersonNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ExceptionHandler(PersonNameCanNotBeNull.class)
    public ResponseEntity<String> personNameNotFound(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name cannot be null");
    }
    @ExceptionHandler(PersonGenderNotValid.class)
    public ResponseEntity<String> genderNotValid(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ExceptionHandler(PersonMaritalStatusNotValid.class)
    public ResponseEntity<String> maritalStatusNotValid(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
