package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.model.Person;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class CarService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CarRepository carRepository;
    public Car addCarToPerson(CarDto carDto) {
        Person p = personRepository.findById(carDto.ownerId).orElseThrow(()->new EntityNotFoundException("Person with provided id not found"));
        if(carRepository.findById(carDto.carId).isPresent()) throw new EntityExistsException("Car with provided id already exist");
        if(new Date().getTime() - p.getBirthdate().getTime() < 567648000000L) throw new RuntimeException("Person must be 18+ years old");
        Car car = new Car();
        car.setId(carDto.carId);
        car.setHorsepower(carDto.horsepower);
        car.setModel(carDto.model);
        car.setOwnerId(p);
        carRepository.save(car);
        return car;
    }
}
