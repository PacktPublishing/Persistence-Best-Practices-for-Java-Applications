package org.a4j.workshop.helidon.restaurant;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@RequestScoped
@Path("restaurants")
public class RestaurantController {

    private Restaurant repository;

    /**
     * @Deprecated CDI only
     */
    RestaurantController() {
    }

    @Inject
    RestaurantController(Restaurant repository) {
        this.repository = repository;
    }

    //TODO don't worried about pagination
    @GET
    @Operation(summary = "Get all items", description = "Returns all available items at the restaurant")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "The items")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The items",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Collection.class,
                            readOnly = true, description = "the items",
                            required = true, name = "items")))
    public Collection<Item> getAll() {
        return repository.getAll();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Find an item by id", description = "Find an item by id")
    @APIResponse(responseCode = "200", description = "The item")
    @APIResponse(responseCode = "404", description = "When the id does not exist")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @APIResponse(description = "The Item",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Item.class)))
    public Item findById(@Parameter(description = "The item ID", required = true, example = "water",
            schema = @Schema(type = SchemaType.STRING))
                         @PathParam("id") String id) {
        return this.repository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no item with the id "
                        + id, Response.Status.NOT_FOUND));
    }

    @POST
    @Operation(summary = "Insert an item", description = "Insert an Item")
    @APIResponse(responseCode = "201", description = "When creates an item")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response insert(@RequestBody(description = "Create a new Item.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Item.class))) @Valid Item item) {
        return Response.status(Response.Status.CREATED)
                .entity(repository.save(item))
                .build();
    }

    @PUT
    @Path("{id}")
    public Item update(@PathParam("id") String id, @Valid Item item) {
        Item databaseItem = repository.findById(id)
                .orElseThrow(
                        () -> new WebApplicationException("There is no item with the id " + id, Response.Status.NOT_FOUND));
        databaseItem.update(item, repository);
        return databaseItem;
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an item by ID", description = "Delete an item by ID")
    @APIResponse(responseCode = "200", description = "When deletes the item")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    public Response delete(@PathParam("id") String id) {
        this.repository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
