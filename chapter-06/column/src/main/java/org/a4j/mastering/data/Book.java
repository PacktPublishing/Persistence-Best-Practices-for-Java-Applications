package org.a4j.mastering.data;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.UUID;

@Entity
public class Book {


    @Column
    private UUID id;

    @Column
    private String title;

}
