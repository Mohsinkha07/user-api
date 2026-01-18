package com.avizva.app.entity;

public class PersonDTO {

    private String name;
    private Gender gender;
    private MaritalStatus maritalStatus;

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.gender = person.getGender();
        this.maritalStatus = person.getMaritalStatus();
    }

    public PersonDTO(String name, Gender gender, MaritalStatus maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
