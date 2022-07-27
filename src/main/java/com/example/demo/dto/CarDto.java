package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class CarDto {
    @NotNull(message = "Owner id must be not null")
    public Long ownerId;

    @NotNull(message = "Car id must not be null")
    public Long carId;

    @NotNull(message = "Car model must not be null")
    @Pattern(regexp =  "^[A-Za-z\\d]+-[A-Za-z\\d]+$", message = "Model pattern vendor-model, only A-Z a-z characters")
    public String model;

    @NotNull(message = "Horsepower must not be null")
    @Positive(message = "Horsepower must be positive value")
    public Integer horsepower;
}
