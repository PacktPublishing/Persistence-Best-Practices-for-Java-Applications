package org.a4j.mastering.data.mapper;

import org.a4j.mastering.data.Book;
import org.a4j.mastering.data.db.Database;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DatabaseConverter implements Function<Book, Map<String, Object>> {

    @Override
    public Map<String, Object> apply(Book book) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("title", book.getTitle());
        entry.put("author", book.getAuthor());
        entry.put("publisher", book.getPublisher());
        entry.put("author", book.getAuthor());
        Database database = Database.INSTANCE;
        database.insert(book.getTitle(), entry);
        return entry;
    }
}
