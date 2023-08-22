package com.example.spdemohateoas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonList  extends RepresentationModel<PersonList> {

    private List<Person> personList = new ArrayList<>();

}
