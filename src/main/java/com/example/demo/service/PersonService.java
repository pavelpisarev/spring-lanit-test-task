package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person addPerson(PersonDto personDto) throws ParseException {
        if (personRepository.findById(personDto.id).isPresent()) throw new EntityExistsException("Person with provided id already exist");
        Person p = new Person();
        p.setId(personDto.id);
        p.setName(personDto.name);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        p.setBirthdate(df.parse(personDto.birthdate));
        return personRepository.save(p);
    }

    public Person personWithCars(Long personId) {
        return personRepository.findById(personId).orElseThrow(()->new EntityNotFoundException("Person with provided id not found"));
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
