package org.a4j.mastering.data.dao;

import org.a4j.mastering.data.Book;

import java.util.Optional;

public interface BookDAO {

    Optional<Book> findById(String title);

    void insert(Book book);

    void update(Book book);

    void deleteByTitle(String title);
}
