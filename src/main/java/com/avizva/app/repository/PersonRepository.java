package com.avizva.app.repository;

import com.avizva.app.entity.Gender;
import com.avizva.app.entity.MaritalStatus;
import com.avizva.app.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{


    Optional<Person> findById(int id);
    Page<Person> findAll(Pageable pageable);
    @Modifying
    @Query(value = "INSERT INTO PERSON (name,gender, maritalStatus) VALUES (:name,:gender, :maritalStatus)", nativeQuery = true)
    void addPerson(@Param("name") String name,@Param("gender") Gender gender, @Param("maritalStatus") MaritalStatus maritalStatus);
}