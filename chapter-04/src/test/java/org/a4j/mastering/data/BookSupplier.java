package org.a4j.mastering.data;

import com.github.javafaker.Faker;

import java.util.function.Supplier;

public enum BookSupplier implements Supplier<Book> {
    INSTANCE;

    private final Faker faker = new Faker();

    @Override
    public Book get() {
        com.github.javafaker.Book book = faker.book();

        return Book.builder()
                .title(book.title())
                .author(book.author())
                .genre(book.genre())
                .publisher(book.publisher())
                .build();
    }
}
