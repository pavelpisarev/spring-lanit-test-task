package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column (name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "birthdate", nullable = false)
    @Past(message = "Date must be in past")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthdate;

    @OneToMany(mappedBy = "ownerId", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();
}
