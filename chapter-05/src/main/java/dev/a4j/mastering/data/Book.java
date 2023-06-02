package dev.a4j.mastering.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.Year;
import java.util.List;

@Entity
public class Book extends PanacheEntity {

    public String name;

    public int release;

    public int edition;

    public static List<Book> findByName(String name) {
        return list("name", name);
    }


}
