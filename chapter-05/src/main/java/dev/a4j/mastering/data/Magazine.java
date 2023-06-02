package dev.a4j.mastering.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Magazine {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public int release;

    public int edition;


}
