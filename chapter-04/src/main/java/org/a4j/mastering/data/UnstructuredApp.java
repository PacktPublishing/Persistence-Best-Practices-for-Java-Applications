package org.a4j.mastering.data;

import org.a4j.mastering.data.db.BookSupplier;
import org.a4j.mastering.data.db.Database;

import java.util.HashMap;
import java.util.Map;

public class UnstructuredApp {

    public static void main(String[] args) {
        Book book = BookSupplier.INSTANCE.get();
        Map<String, Object> entry = new HashMap<>();
        entry.put("title", book.getTitle());
        entry.put("author", book.getAuthor());
        entry.put("publisher", book.getPublisher());
        entry.put("author", book.getAuthor());
        Database database = Database.INSTANCE;
        database.insert(book.getTitle(), entry);

        Map<String, Object> map = database.findById(book.getTitle())
                .orElseThrow();

        Book entity = Book.builder()
                .title((String) map.get("title"))
                .author((String) map.get("author"))
                .publisher((String) map.get("publisher"))
                .author((String) map.get("author"))
                .build();

        System.out.println("the entity result: " + entity);
    }
}
