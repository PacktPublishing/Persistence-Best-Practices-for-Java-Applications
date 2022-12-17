package org.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class User {

    @Column
    private String username;

    @Column
    private String name;
}
