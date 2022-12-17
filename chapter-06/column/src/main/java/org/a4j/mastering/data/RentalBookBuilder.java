package org.a4j.mastering.data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class RentalBookBuilder {
    private UUID id;
    private LocalDate date;
    private User user;
    private Set<Book> books = new HashSet<>();

    public RentalBookBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public RentalBookBuilder date(LocalDate date) {
        this.date = date;
        return this;
    }

    public RentalBookBuilder user(User user) {
        this.user = user;
        return this;
    }

    public RentalBookBuilder book(Book book) {
        Objects.requireNonNull(book, "book is required");
        this.books.add(book);
        return this;
    }

    public RentalBook build() {
        return new RentalBook(id, date, user, books);
    }
}