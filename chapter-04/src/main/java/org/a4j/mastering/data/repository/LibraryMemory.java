package org.a4j.mastering.data.repository;

import org.a4j.mastering.data.Book;
import org.a4j.mastering.data.dao.BookDAO;

import java.util.Objects;
import java.util.Optional;

public class LibraryMemory implements Library {

    private final BookDAO dao;

    public LibraryMemory(BookDAO dao) {
        this.dao = dao;
    }


    @Override
    public Book register(Book book) {
        Objects.requireNonNull(book, "book is required");
        if(dao.findByTitle(book.getTitle()).isPresent()) {
            dao.update(book);
        } else {
            dao.insert(book);
        }
        return book;
    }

    @Override
    public Book unregister(Book book) {
        Objects.requireNonNull(book, "book is required");
        dao.deleteByTitle(book.getTitle());
        return book;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        Objects.requireNonNull(title, "title is required");
        return dao.findByTitle(title);
    }
}
