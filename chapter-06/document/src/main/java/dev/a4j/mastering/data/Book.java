package dev.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
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

    Book(String id, String title, List<String> categories, Set<String> languages, Author author) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.languages = languages;
        this.author = author;
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

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                ", languages=" + languages +
                ", author=" + author +
                '}';
    }
}
