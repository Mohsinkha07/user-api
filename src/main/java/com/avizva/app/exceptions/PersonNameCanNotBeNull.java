package com.avizva.app.exceptions;

public class PersonNameCanNotBeNull extends RuntimeException {
    public PersonNameCanNotBeNull(String message) {
        super(message);
    }
}
