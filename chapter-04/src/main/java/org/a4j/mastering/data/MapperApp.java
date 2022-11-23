package org.a4j.mastering.data;

import org.a4j.mastering.data.mapper.Mapper;

public class MapperApp {

    public static void main(String[] args) {
        Book book = BookSupplier.INSTANCE.get();
        Mapper mapper = new Mapper();
        mapper.insert(book);

        Book entity = mapper.findById(book.getTitle())
                .orElseThrow();

        System.out.println("the entity result: " + entity);
    }
}
