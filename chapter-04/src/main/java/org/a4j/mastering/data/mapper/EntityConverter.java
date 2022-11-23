package org.a4j.mastering.data.mapper;

import org.a4j.mastering.data.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EntityConverter implements Function<Map<String, Object>, Book> {

    @Override
    public Book apply(Map<String, Object> map) {
        Book entity = Book.builder()
                .title((String) map.get("title"))
                .author((String) map.get("author"))
                .publisher((String) map.get("publisher"))
                .author((String) map.get("author"))
                .build();
        return entity;
    }
}
