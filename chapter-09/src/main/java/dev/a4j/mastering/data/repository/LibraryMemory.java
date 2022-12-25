package dev.a4j.mastering.data.repository;

import dev.a4j.mastering.data.Book;
import dev.a4j.mastering.data.dao.BookDAO;

import java.util.Objects;
import java.util.Optional;

public class LibraryMemory implements Library {

    private final BookDAO dao;

    public LibraryMemory(BookDAO dao) {
        this.dao = dao;
    }

    @Override
    public Book save(Book book) {
        Objects.requireNonNull(book, "book is required");
        if(dao.findById(book.getTitle()).isPresent()) {
            dao.update(book);
        } else {
            dao.insert(book);
        }
        return book;
    }

    @Override
    public void unregister(Book book) {
        Objects.requireNonNull(book, "book is required");
        dao.deleteByTitle(book.getTitle());
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        Objects.requireNonNull(title, "title is required");
        return dao.findById(title);
    }
}
