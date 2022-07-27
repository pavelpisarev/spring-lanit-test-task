package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
public class PersonDto {
    @NotNull(message = "Id must be not null")
    public Long id;

    @NotNull(message = "Name must be not null")
    @Pattern(regexp = "^[A-zA-z]+$", message = "Only A-Z a-z symbols available")
    public String name;

    @NotNull(message = "Birthdate must be not null")
    @Pattern(regexp = "^\\d{2}.\\d{2}.\\d{4}$", message = "Date format should be dd.MM.YYYY")
    public String birthdate;
}
