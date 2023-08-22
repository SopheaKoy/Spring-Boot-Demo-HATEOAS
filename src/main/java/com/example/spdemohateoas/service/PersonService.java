package com.example.spdemohateoas.service;

import com.example.spdemohateoas.entity.Person;
import com.example.spdemohateoas.entity.PersonResult;

import java.util.List;

public interface PersonService {


    List <Person> getAll();

    Person getById(Integer id);

    PersonResult getId(Integer id);

}
