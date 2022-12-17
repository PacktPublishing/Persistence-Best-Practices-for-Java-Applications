package org.a4j.mastering.data;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class Book {


    @Column
    private Long id;

    @Column
    private String title;

}
