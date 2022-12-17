package org.a4j.mastering.data;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Book {


    @Column
    private UUID id;

    @Column
    private String title;

    Book() {
    }

    private Book(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public static Book of(UUID id, String title) {
        Objects.requireNonNull(id, " id is required");
        Objects.requireNonNull(title, " title is required");
        return new Book(id, title);
    }
}
