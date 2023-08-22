package com.example.spdemohateoas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends RepresentationModel<Person> {

    // we need you extends for RepresentationModel for create collect link

    private Integer id;

    private String name;

    private String address;

}
