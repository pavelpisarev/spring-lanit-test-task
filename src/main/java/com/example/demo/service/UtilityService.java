package com.example.demo.service;

import com.example.demo.dto.StatisticsDto;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UtilityService {
    @Autowired
    CarService carService;

    @Autowired
    PersonService personService;

    public StatisticsDto getStats() {
        List<Person> p = personService.personRepository.findAll();
        Long personCount = (long) p.size();
        Long carCount = (long) carService.carRepository.findAll().size();
        Set<String> vendors = new HashSet<>() {
        };
        for (Person person : p) {
            for (int j = 0; j < person.getCars().size(); j++) {
                vendors.add(person.getCars().get(j).getModel().split("-")[0].toLowerCase());
            }
        }
        Long uniquevendorcount = (long) vendors.size();
        StatisticsDto statisticsDto;
        return new StatisticsDto(personCount, carCount, uniquevendorcount);
    }
}
