package org.a4j.mastering.data;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;


@Entity
public record Author(@Column("nickname") String nickname, @Column("name") String name, @Column("profile") String profile) {
}
