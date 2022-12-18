package org.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Id;

import java.util.List;
import java.util.Set;

public class Book {

    @Id
    private String id;

    @Column
    private String title;

    @Column
    private List<String> categories;

    @Column
    private Set<String> languages;

    @Column
    private Author author;

    Book() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Author getAuthor() {
        return author;
    }
}
