package dev.a4j.mastering.data;

import java.util.Objects;


public class Developer {

    private String nickname;

    private String name;

    private String city;

    private String language;


    Developer() {
    }

    Developer(String nickname, String name, String city, String language) {
        this.nickname = nickname;
        this.name = name;
        this.city = city;
        this.language = language;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Developer developer = (Developer) o;
        return Objects.equals(nickname, developer.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", language=" + language +
                '}';
    }

    public static DeveloperBuilder builder() {
        return new DeveloperBuilder();
    }
}
