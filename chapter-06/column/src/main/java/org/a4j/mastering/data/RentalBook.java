package org.a4j.mastering.data;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.mapping.cassandra.column.UDT;
import org.eclipse.jnosql.mapping.cassandra.converters.TimestampConverter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity("rental")
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
    private Set<Book> books = new HashSet<>();

    RentalBook() {
    }

    RentalBook(UUID id, LocalDate date, User user, Set<Book> books) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.books = books;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RentalBook that = (RentalBook) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "RentalBook{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", books=" + books +
                '}';
    }

    public static RentalBookBuilder builder() {
        return new RentalBookBuilder();
    }
}
