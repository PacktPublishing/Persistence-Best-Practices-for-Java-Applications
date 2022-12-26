package dev.a4j.mastering.data;

public class BookBuilder {
    private String isbn;
    private String title;
    private String author;

    BookBuilder() {
    }

    public BookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public Book build() {
        return new Book(isbn, title, author);
    }
}