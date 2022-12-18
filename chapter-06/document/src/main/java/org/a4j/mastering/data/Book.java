package org.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Id;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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

    public String getAuthor() {
        return author;
    }
}
