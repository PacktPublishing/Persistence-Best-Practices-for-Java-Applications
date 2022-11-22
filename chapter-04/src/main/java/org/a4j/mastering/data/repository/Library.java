package org.a4j.mastering.data.repository;

import org.a4j.mastering.data.Book;

import java.util.Optional;

public interface Library {

    Book register(Book book);

    Book unregister(Book book);

    Optional<Book> findByTitle(String title);
}
