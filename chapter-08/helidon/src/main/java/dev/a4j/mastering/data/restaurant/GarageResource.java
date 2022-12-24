package dev.a4j.mastering.data.restaurant;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@ApplicationScoped
@Path("garage")
public class GarageResource {

    @Inject
    private CarService service;
    @GET
    public List<Car> getCars() {
        return this.service.getCars();
    }


    @Path("{model}")
    public Car findByModel(@PathParam("model") String model) {
        return this.service.findByModel(model)
                .orElseThrow(() -> new WebApplicationException(NOT_FOUND));
    }

    @POST
    public Car add(Car car) {
        this.service.add(car);
        return car;
    }
}
