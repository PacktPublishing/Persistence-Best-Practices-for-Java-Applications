package dev.a4j.mastering.data;

import java.time.Year;

public class CarBuilder {

    private String plate;
    private Year year;
    private String name;
    private String model;


    public CarBuilder plate(String plate) {
        this.plate = plate;
        return this;
    }

    public CarBuilder year(Year year) {
        this.year = year;
        return this;
    }

    public CarBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public Car build() {
        return new Car(plate, year, name, model);
    }
}
