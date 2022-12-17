package org.a4j.mastering.data;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.mapping.cassandra.column.UDT;
import org.eclipse.jnosql.mapping.cassandra.converters.TimestampConverter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


@Entity
public class RentalBook {

    @Id
    private UUID id;

    @Column
    @Convert(value = TimestampConverter.class)
    private LocalDate date;

    @Column
    @UDT("user")
    private User user;

    @Column
    @UDT("book")
    private Set<Book> books;
}
