package dev.a4j.mastering.data;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/library")
public class BookResource {

    @GET
    public List<Book> findAll() {
        return Book.listAll();
    }

    @GET
    @Path("{name}")
    public List<Book> findByName(@PathParam("name") String name) {
        return Book.findByName(name);
    }

    @POST
    @Transactional
    public void insert(Book book) {
        book.persist();
    }
}
