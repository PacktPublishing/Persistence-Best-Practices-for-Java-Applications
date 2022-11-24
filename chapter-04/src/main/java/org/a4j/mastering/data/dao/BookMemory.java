package org.a4j.mastering.data.dao;

import org.a4j.mastering.data.Book;
import org.a4j.mastering.data.mapper.BookMapper;

import java.util.Optional;

public class BookMemory implements BookDAO {

    private final BookMapper mapper;

    public BookMemory() {
        this.mapper = new BookMapper();
    }

    @Override
    public Optional<Book> findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public void insert(Book book) {
        this.mapper.insert(book);
    }

    @Override
    public void update(Book book) {
        mapper.update(book);
    }

    @Override
    public void deleteByTitle(String title) {
        this.mapper.delete(title);
    }
}
