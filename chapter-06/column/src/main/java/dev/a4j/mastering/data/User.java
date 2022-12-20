package dev.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;

@Entity
public class User {

    @Column
    private String username;

    @Column
    private String name;

    User() {
    }

    private User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static User of(String username, String name) {
        Objects.requireNonNull(username, "username is required");
        Objects.requireNonNull(name, "name is required");
        return new User(username, name);
    }
}
