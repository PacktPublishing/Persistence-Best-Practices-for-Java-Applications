package org.a4j.mastering.data.repository;

import org.a4j.mastering.data.Book;

import java.util.Optional;

public interface Library {

    Book save(Book book);

    Optional<Book> findByTitle(String title);
}
