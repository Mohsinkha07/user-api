package com.avizva.app.repository;

import com.avizva.app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{

    Person findById(int id);
    @Modifying
    @Query(value = "INSERT INTO PERSON (name, maritalStatus) VALUES (:name, :maritalStatus)", nativeQuery = true)
    void addPerson(@Param("name") String name, @Param("maritalStatus") String maritalStatus);
}