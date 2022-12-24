package dev.a4j.mastering.data;


import one.microstream.integrations.cdi.types.Storage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Storage
public class Garage {

    private Set<Car> cars;


    public Garage() {
        this.cars = new HashSet<>();
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars.stream().toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Garage garage = (Garage) o;
        return Objects.equals(cars, garage.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
