package org.a4j.workshop.helidon.restaurant.infra;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Provider
public class BeanValidationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        List<String> errorMessages = constraintViolations.stream()
                .map(constraintViolation -> {
                    String name = getName(constraintViolation);
                    return name + " " + constraintViolation.getMessage();
                })
                .collect(Collectors.toList());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessages)
                .build();
    }

    private String getName(ConstraintViolation<?> constraintViolation) {
        Path.Node node = StreamSupport.stream(constraintViolation.getPropertyPath().spliterator(), false)
        .reduce((first, second) -> second)
                .orElse(null);
        return node.getName();
    }

}