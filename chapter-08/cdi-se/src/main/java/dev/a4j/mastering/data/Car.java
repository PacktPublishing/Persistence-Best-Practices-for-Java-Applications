package dev.a4j.mastering.data;

import java.time.Year;
import java.util.Objects;

public class Car{

    private final String make;
    private final Year year;

    private final String name;

    private final String model;

    Car(String make, Year year, String name, String model) {
        this.make = make;
        this.year = year;
        this.name = name;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public Year getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make)
                && Objects.equals(year, car.year)
                && Objects.equals(name, car.name)
                && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, year, name, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

}
