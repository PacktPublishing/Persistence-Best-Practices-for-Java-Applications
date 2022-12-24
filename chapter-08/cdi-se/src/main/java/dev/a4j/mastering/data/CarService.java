package dev.a4j.mastering.data;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CarService {

    @Inject
    private Garage garage;
}
