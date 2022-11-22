package org.a4j.mastering.data;

import java.time.Year;

public class CarBuilder {
    private String plate;
    private String name;
    private Year year;
    private String model;

    public CarBuilder plate(String plate) {
        this.plate = plate;
        return this;
    }

    public CarBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder year(Year year) {
        this.year = year;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public Car createCar() {
        return new Car(plate, name, year, model);
    }
}