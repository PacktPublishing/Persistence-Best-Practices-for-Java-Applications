package dev.a4j.mastering.data;

import jakarta.data.Entity;
import jakarta.data.Id;

import java.util.Objects;
import java.util.Set;


@Entity
public class Developer {

    @Id
    private String nickname;

    private String name;

    private String city;

    private Set<String> languages;


    Developer() {
    }

    Developer(String nickname, String name, String city, Set<String> languages) {
        this.nickname = nickname;
        this.name = name;
        this.city = city;
        this.languages = languages;
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

    public Set<String> getLanguages() {
        return languages;
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
                ", languages=" + languages +
                '}';
    }
}
