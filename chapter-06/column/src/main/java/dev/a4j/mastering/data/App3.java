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

package dev.a4j.mastering.data;


import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.LocalDate;
import java.util.UUID;


public class App3 {


    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            RentalBook poliana = RentalBook.builder()
                    .id(UUID.randomUUID())
                    .date(LocalDate.now())
                    .user(User.of("poly", "Poliana Santana"))
                    .book(Book.of(UUID.randomUUID(), "The Shack"))
                    .build();

           RentalBookRepository repository = container.select(RentalBookRepository.class).get();

            repository.save(poliana);


            System.out.println("the return value: " +   repository.findById(poliana.getId()));

        }

        System.exit(0);
    }

    private App3() {}
}
