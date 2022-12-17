package org.a4j.mastering.data;

import java.util.HashSet;
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
        this.userName = userName;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder languages(Set<String> languages) {
        this.languages = languages;
        return this;
    }

    public UserBuilder categories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public User build() {
        return new User(userName, name, languages, categories);
    }
}