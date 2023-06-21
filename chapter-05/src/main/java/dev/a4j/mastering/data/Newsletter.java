package dev.a4j.mastering.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Newsletter extends PanacheEntity {
    public String author;
    public String headline;
}
