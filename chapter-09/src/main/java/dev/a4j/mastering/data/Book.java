package dev.a4j.mastering.data;


import jakarta.data.Entity;
import jakarta.data.Id;

@Entity
public class Book {

    @Id
    private String id;

    private String title;

    private String author;

}
