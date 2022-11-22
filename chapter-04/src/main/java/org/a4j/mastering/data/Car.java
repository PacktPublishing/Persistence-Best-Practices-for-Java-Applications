package org.a4j.mastering.data;

import java.time.Year;

public class Car {

    private final String plate;

    private final String name;

    private final Year year;

    private final String model;

    Car(String plate, String name, Year year, String model) {
        this.plate = plate;
        this.name = name;
        this.year = year;
        this.model = model;
    }
}
