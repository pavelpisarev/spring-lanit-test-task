package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "horsepower", nullable = false)
    private Integer horsepower;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Person ownerId;
}
