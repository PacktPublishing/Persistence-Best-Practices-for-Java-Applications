package dev.a4j.mastering.data.dao;

import dev.a4j.mastering.data.Book;

import java.util.Optional;

public interface BookDAO {

    Optional<Book> findById(String id);

    void insert(Book book);

    void update(Book book);

    void deleteByTitle(String title);
}
