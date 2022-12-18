package org.a4j.mastering.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class BookBuilder {
    private String id = UUID.randomUUID().toString();
    private String title;
    private List<String> categories  = new ArrayList<>();
    private Set<String> languages = new HashSet<>();
    private Author author;

    BookBuilder() {
    }

    public BookBuilder id(String id) {
        Objects.requireNonNull(id, "id is required");
        this.id = id;
        return this;
    }

    public BookBuilder title(String title) {
        Objects.requireNonNull(title, "title is required");
        this.title = title;
        return this;
    }

    public BookBuilder categories(List<String> categories) {
        Objects.requireNonNull(categories, "categories is required");
        this.categories.addAll(categories);
        return this;
    }

    public BookBuilder languages(Set<String> languages) {
        Objects.requireNonNull(languages, "languages is required");
        this.languages.addAll(languages);
        return this;
    }

    public BookBuilder category(String category) {
        Objects.requireNonNull(category, "category is required");
        this.categories.add(category);
        return this;
    }

    public BookBuilder language(Set<String> languages) {
        Objects.requireNonNull(languages, "languages is required");
        this.languages = languages;
        return this;
    }

    public BookBuilder author(Author author) {
        Objects.requireNonNull(author, "author is required");
        this.author = author;
        return this;
    }

    public Book build() {
        return new Book(id, title, categories, languages, author);
    }
}