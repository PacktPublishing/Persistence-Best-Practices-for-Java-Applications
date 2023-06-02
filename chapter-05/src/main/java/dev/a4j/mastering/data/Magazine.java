package dev.a4j.mastering.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Magazine extends PanacheEntity {

    public String name;

    public int release;

    public int edition;

    public static List<Magazine> findByName(String name) {
        return list("name", name);
    }


}
