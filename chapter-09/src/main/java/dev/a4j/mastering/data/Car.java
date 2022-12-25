package dev.a4j.mastering.data;


import jakarta.data.Entity;
import jakarta.data.Id;

import java.time.Year;

@Entity
public class Car {

    @Id
    private String plate;

    private String model;

    private Year year;
}
