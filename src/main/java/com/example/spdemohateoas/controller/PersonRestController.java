package com.example.spdemohateoas.controller;

import com.example.spdemohateoas.entity.Person;
import com.example.spdemohateoas.entity.PersonList;
import com.example.spdemohateoas.entity.PersonResult;
import com.example.spdemohateoas.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;
    @GetMapping
    public PersonList getAll(){

        PersonList personList = new PersonList();

        for (Person person: personService.getAll()){

            addLinkToPerson(person);
            personList.getPersonList().add(person);

        }

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonRestController.class).getAll()).withSelfRel();

        personList.add(link);

        return personList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Integer id){

        Person person = personService.getById(id);

       addLinkToPerson(person);

        return new ResponseEntity<>( person, HttpStatus.OK);
    }

    @GetMapping("/{id}/report")
    public ResponseEntity<PersonResult> getId(@PathVariable Integer id){


        PersonResult personResult = personService.getId(id);

        return new ResponseEntity<>( personResult, HttpStatus.OK);
    }


    private void addLinkToPerson(Person person){

        Link link = WebMvcLinkBuilder.linkTo(PersonRestController.class).slash(person.getId()).withSelfRel();

        person.add(link);

        ResponseEntity<?> methodLinkBuilder = WebMvcLinkBuilder.methodOn(PersonRestController.class)
                .getId(person.getId());

        Link reportLink = WebMvcLinkBuilder.linkTo(methodLinkBuilder).withRel("person-report");
        person.add(reportLink);

    }

}
