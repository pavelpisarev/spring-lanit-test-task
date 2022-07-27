package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.text.ParseException;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @PostMapping("/person")
    public ResponseEntity<?> addPerson(@Valid @RequestBody @NotNull PersonDto personDto) {
        LOG.info("POST request /person");
        try {
            Person p = personService.addPerson(personDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            LOG.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/personwithcars")
    public ResponseEntity<?> personWithCars(@NotNull @RequestParam("personid") Long personId) {
        LOG.info("GET request /personwithcars?id="+personId);
        try {
            return new ResponseEntity<>(personService.personWithCars(personId), HttpStatus.OK);
        } catch (EntityNotFoundException e){
            LOG.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            LOG.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

