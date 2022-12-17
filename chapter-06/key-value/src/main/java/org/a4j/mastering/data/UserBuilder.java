package org.a4j.mastering.data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserBuilder {
    private String userName;
    private String name;
    private Set<String> languages;
    private Set<String> categories;

    UserBuilder() {
        this.languages = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public UserBuilder userName(String userName) {
        Objects.requireNonNull(userName, "username is required");
        this.userName = userName;
        return this;
    }

    public UserBuilder name(String name) {
        Objects.requireNonNull(name, "name is required");
        this.name = name;
        return this;
    }

    public UserBuilder languages(Set<String> languages) {
        Objects.requireNonNull(languages, "languages is required");
        this.languages.addAll(languages);
        return this;
    }


    public UserBuilder categories(Set<String> categories) {
        Objects.requireNonNull(categories, "categories is required");
        this.categories.addAll(categories);
        return this;
    }

    public UserBuilder language(String language) {
        Objects.requireNonNull(language, "language is required");
        this.languages.add(language);
        return this;
    }


    public UserBuilder category(String category) {
        Objects.requireNonNull(category, "category is required");
        this.categories.add(category);
        return this;
    }

    public User build() {
        return new User(userName, name, languages, categories);
    }
}