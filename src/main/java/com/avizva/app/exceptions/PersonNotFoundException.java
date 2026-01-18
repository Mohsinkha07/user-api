package com.avizva.app.exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String msg){
        super("Person Doesn't exist");
    }
}
