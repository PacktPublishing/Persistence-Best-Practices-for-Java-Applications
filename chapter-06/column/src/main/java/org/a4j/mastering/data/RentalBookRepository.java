package org.a4j.mastering.data;

import jakarta.nosql.mapping.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public interface RentalBookRepository extends Repository<RentalBook, UUID> {
}
