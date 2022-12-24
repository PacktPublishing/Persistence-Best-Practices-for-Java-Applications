package dev.a4j.mastering.data;


import one.microstream.integrations.cdi.types.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class CarService {

    @Inject
    private Garage garage;

    @Store
    public void add(Car car) {
        Objects.requireNonNull(car, "car is required");
        this.garage.add(car);
    }

    public List<Car> getCars() {
        return this.garage.getCars();
    }
}
