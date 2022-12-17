/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package org.a4j.mastering.data;


import jakarta.nosql.column.ColumnQuery;
import jakarta.nosql.mapping.column.ColumnTemplate;
import org.eclipse.jnosql.mapping.cassandra.column.CassandraTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


public class App2 {


    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            RentalBook otavio = RentalBook.builder()
                    .id(UUID.randomUUID())
                    .date(LocalDate.now())
                    .user(User.of("otaviojava", "Otavio Santana"))
                    .book(Book.of(UUID.randomUUID(), "Clean Code"))
                    .book(Book.of(UUID.randomUUID(), "Effective Java"))
                    .build();

            RentalBook karina = RentalBook.builder()
                    .id(UUID.randomUUID())
                    .date(LocalDate.now())
                    .user(User.of("kvarel4", "Karina Varela"))
                    .book(Book.of(UUID.randomUUID(), "Clean Arch"))
                    .build();

            ColumnTemplate template =  container.select(CassandraTemplate.class).get();

            template.insert(List.of(otavio, karina), Duration.ofDays(600L));

            ColumnQuery query = ColumnQuery.select().from("rental")
                    .where("id").eq(karina.getId()).build();

            System.out.println("Executing query using API: ");
            template.select(query).forEach(System.out::println);

            System.out.println("Executing query using text: ");
            template.query("select * from rental").forEach(System.out::println);

        }

        System.exit(0);
    }
    private App2() {}
}
