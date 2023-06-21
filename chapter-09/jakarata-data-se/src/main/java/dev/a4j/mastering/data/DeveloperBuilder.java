package dev.a4j.mastering.data;

import java.util.Set;

public class DeveloperBuilder {
    private String nickname;
    private String name;
    private String city;
    private String language;

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

    public DeveloperBuilder language(String language) {
        this.language = language;
        return this;
    }

    public Developer build() {
        return new Developer(nickname, name, city, language);
    }
}