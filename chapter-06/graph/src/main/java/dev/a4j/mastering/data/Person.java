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


    Person() {
    }

    private Person(String name) {
        this.name = name;
    }


    public Long id() {
        return id;
    }

    public String name() {
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
                '}';
    }

    public static Person of(String name) {
        Objects.requireNonNull(name, "name is required");
        return new Person(name);
    }
}
