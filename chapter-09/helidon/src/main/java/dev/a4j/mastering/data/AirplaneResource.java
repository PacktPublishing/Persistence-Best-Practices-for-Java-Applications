package dev.a4j.mastering.data;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("airplanes")
public class AirplaneResource {


    private final Hangar repository;

    @Inject
    public AirplaneResource(Hangar repository) {
        this.repository = repository;
    }

    @GET
    public List<Airplane> getDevelopers() {
        return this.repository.findAll().collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    public Airplane findById(@PathParam("id") String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @PUT
    public Airplane insert(Airplane airplane) {
        return this.repository.save(airplane);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") String id) {
        this.repository.deleteById(id);
    }

}
