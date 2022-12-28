package dev.a4j.mastering.data;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("developers")
public class DeveloperResource {


    private final DeveloperRepository repository;

    @Inject
    public DeveloperResource(DeveloperRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<Developer> getDevelopers() {
        return this.repository.findAll().collect(Collectors.toUnmodifiableList());
    }
}
