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


import org.eclipse.jnosql.mapping.cassandra.column.CassandraTemplate;
import jakarta.nosql.mapping.column.ColumnTemplate;
import jakarta.nosql.column.ColumnQuery;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static jakarta.nosql.column.ColumnQuery.select;


public class App {


    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            RentalBook otavio = RentalBook.builder()
                    .id(UUID.randomUUID())
                    .date(LocalDate.now())
                    .user(User.of("otaviojava", "Otavio Santana"))
                    .book(Book.of(UUID.randomUUID(), "Clean Code"))
                    .book(Book.of(UUID.randomUUID(), "Effective Java"))
                    .build();

            ColumnTemplate template =  container.select(CassandraTemplate.class).get();

            template.insert(otavio, Duration.ofDays(600L));

            Optional<RentalBook> book = template.find(RentalBook.class, otavio.getId());
            System.out.println("the return value: " + book);

        }

        System.exit(0);
    }

    private App() {}
}
