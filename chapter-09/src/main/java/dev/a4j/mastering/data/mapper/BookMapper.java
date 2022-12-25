package dev.a4j.mastering.data.mapper;

import dev.a4j.mastering.data.Book;
import dev.a4j.mastering.data.db.Database;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class BookMapper {

    private Database database = Database.INSTANCE;


    public Optional<Book> findById(String id) {
        Objects.requireNonNull(id, "is is required");
        return database.findById(id)
                .map(entity());
    }

    private Function<Map<String, Object>, Book> entity() {
        return (map) ->
            Book.builder()
                    .title((String) map.get("title"))
                    .author((String) map.get("author"))
                    .publisher((String) map.get("publisher"))
                    .genre((String) map.get("genre"))
                    .build();
    }

    private Function<Book, Map<String, Object>> database() {
        return (book) -> {
            Map<String, Object> entry = new HashMap<>();
            entry.put("title", book.getTitle());
            entry.put("author", book.getAuthor());
            entry.put("publisher", book.getPublisher());
            entry.put("genre", book.getGenre());
            return entry;
        };
    }


    public Book insert(Book book) {
        Objects.requireNonNull(book, "book is required");
        Map<String, Object> entry = database().apply(book);
        database.insert(book.getTitle(), entry);
        return book;
    }

    public void delete(String id) {
        Objects.requireNonNull(id, "is is required");
        database.delete(id);
    }

    public Book update(Book book) {
        Objects.requireNonNull(book, "book is required");
        if (findById(book.getTitle()).isEmpty()) {
            throw new IllegalArgumentException("The database cannot be updated");
        }
        Map<String, Object> entry = database().apply(book);
        database.update(book.getTitle(), entry);
        return book;
    }

}
