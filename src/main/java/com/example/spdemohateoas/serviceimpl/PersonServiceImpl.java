package com.example.spdemohateoas.serviceimpl;

import com.example.spdemohateoas.entity.Person;
import com.example.spdemohateoas.entity.PersonResult;
import com.example.spdemohateoas.service.PersonService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {

    List<Person> list = new ArrayList<>(){{

       add(new Person(1, "Sophea", "PP"));
       add(new Person(2, "Saran", "PP"));
       add(new Person(3, "SreyPhea", "PP"));

    }};

    @Override
    public List<Person> getAll() {
        return list;
    }

    @Override
    public Person getById(Integer id) {

        Person person = new Person(1, "Koy Sophea", "Phnom Penh");

        if (Objects.equals(person.getId(), id)){
            System.out.println("Id have been found/");
        }

        return person;
    }

    @Override
    public PersonResult getId(Integer id) {

        PersonResult personResult = new PersonResult(new Person(1, "Sophea" ,"PP"), "Work of school");

       if(Objects.equals(personResult.getPerson().getId(), id)){

           System.out.println("hello everyone");

       }

        return personResult;

    }
}
