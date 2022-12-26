package dev.a4j.mastering.data;

import java.util.Set;

public class DeveloperBuilder {
    private String nickname;
    private String name;
    private String city;
    private Set<String> languages;

    public DeveloperBuilder nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public DeveloperBuilder name(String name) {
        this.name = name;
        return this;
    }

    public DeveloperBuilder city(String city) {
        this.city = city;
        return this;
    }

    public DeveloperBuilder languages(Set<String> languages) {
        this.languages = languages;
        return this;
    }

    public Developer createDeveloper() {
        return new Developer(nickname, name, city, languages);
    }
}