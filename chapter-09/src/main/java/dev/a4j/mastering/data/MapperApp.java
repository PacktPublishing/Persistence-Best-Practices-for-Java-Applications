package dev.a4j.mastering.data;

import dev.a4j.mastering.data.db.BookSupplier;
import dev.a4j.mastering.data.mapper.BookMapper;

public class MapperApp {

    public static void main(String[] args) {
        Book book = BookSupplier.INSTANCE.get();
        BookMapper mapper = new BookMapper();
        mapper.insert(book);
        Book entity = mapper.findById(book.getTitle())
                .orElseThrow();

        System.out.println("the entity result: " + entity);
    }
}
