package org.a4j.mastering.data.activerecord;

public class BookBuilder {
    private String title;
    private String author;
    private String publisher;
    private String genre;

    BookBuilder() {
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder publisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    public Book build() {
        return new Book(title, author, publisher, genre);
    }
}