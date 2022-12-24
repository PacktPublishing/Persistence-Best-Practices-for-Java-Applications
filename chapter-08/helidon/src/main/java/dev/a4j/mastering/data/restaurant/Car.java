package dev.a4j.mastering.data.restaurant;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Year;
import java.util.Objects;

public class Car {

    private final String plate;
    private final Year year;

    private final String make;

    private final String model;

    @JsonbCreator
    public Car(@JsonbProperty("plate") String plate,
               @JsonbProperty("year") Year year,
               @JsonbProperty("make") String make,
               @JsonbProperty("model") String model) {
        this.plate = plate;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public Year getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(plate, car.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

}
