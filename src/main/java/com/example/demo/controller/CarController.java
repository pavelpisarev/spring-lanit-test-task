package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @PostMapping
    public ResponseEntity<?> addCarToPerson(@Valid @RequestBody @NotNull CarDto carDto) {
        LOG.info("\nPOST request /car");
        try {
            Car car = carService.addCarToPerson(carDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOG.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
