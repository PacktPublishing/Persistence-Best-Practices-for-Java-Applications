package org.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Map;


@Entity
public class Author {

    @Column
    private String nickname;

    @Column
    private String name;

    @Column
    private String profile;
}
