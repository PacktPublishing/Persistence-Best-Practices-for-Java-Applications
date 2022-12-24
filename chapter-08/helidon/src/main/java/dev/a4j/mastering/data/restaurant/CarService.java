package dev.a4j.mastering.data.restaurant;


import one.microstream.integrations.cdi.types.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Car> findByModel(String model) {
        Objects.requireNonNull(model, "model is required");
        return this.garage.findByModel(model);
    }
}
