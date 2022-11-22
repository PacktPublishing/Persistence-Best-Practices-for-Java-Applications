package org.a4j.mastering.data.dao;

import org.a4j.mastering.data.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class BookMemory implements BookDAO {

    private final Map<String, Book> data;

    public BookMemory() {
        this.data = new HashMap<>();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        Objects.requireNonNull(title, "title is required");
        return Optional.ofNullable(this.data.get(title));
    }

    @Override
    public void insert(Book book) {
        Objects.requireNonNull(book, "book is required");
        this.data.put(book.getTitle(), book);
    }

    @Override
    public void update(Book book) {
        Objects.requireNonNull(book, "book is required");
        if (this.data.get(book.getTitle()) == null) {
            throw new IllegalArgumentException("You cannot update the information that is not in the database");
        }
        this.data.put(book.getTitle(), book);
    }

    @Override
    public void deleteByTitle(String title) {
        Objects.requireNonNull(title, "title is required");
        this.data.remove(title);
    }
}
