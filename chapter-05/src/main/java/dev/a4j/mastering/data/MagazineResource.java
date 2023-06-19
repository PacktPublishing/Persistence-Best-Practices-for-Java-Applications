package dev.a4j.mastering.data;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/magazines")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MagazineResource {

    @Inject
    MagazineRepository repository;
    @GET
    public List<Magazine> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("name/{name}")
    public List<Magazine> findByName(@PathParam("name") String name) {
        return repository.findByName(name);
    }

    @GET
    @Path("release/{year}")
    public List<Magazine> findByYear(@PathParam("year") int year) {
        return repository.findByRelease(year);
    }

    @POST
    @Transactional
    public Magazine insert(Magazine magazine) {
        this.repository.persist(magazine);
        return magazine;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}

