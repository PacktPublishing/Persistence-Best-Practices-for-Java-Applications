package dev.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Objects;

@Entity
public class Person {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String profile;


    Person() {
    }

    private Person(String name, String profile) {
        this.name = name;
        this.profile = profile;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }

    public static Person of(String name, String profile) {
        Objects.requireNonNull(name, "name is required");
        Objects.requireNonNull(profile, "profile is required");
        return new Person(name, profile);
    }
}
