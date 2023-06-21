package dev.a4j.mastering.data.repository;

import dev.a4j.mastering.data.Book;

import java.util.Optional;

public interface Library {

    Book register(Book book);

    Optional<Book> findByTitle(String title);

    void unregister(Book book);
}
