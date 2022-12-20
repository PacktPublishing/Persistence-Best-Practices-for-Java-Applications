package dev.a4j.mastering.data;

import org.eclipse.jnosql.mapping.cassandra.column.CassandraRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public interface RentalBookRepository extends CassandraRepository<RentalBook, UUID> {
}
