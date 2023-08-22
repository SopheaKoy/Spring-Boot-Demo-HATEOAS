package com.example.spdemohateoas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResult extends RepresentationModel<PersonResult> {

    private Person person;

    private String report;


}
