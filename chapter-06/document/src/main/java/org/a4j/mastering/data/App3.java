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


import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.PreparedStatement;
import jakarta.nosql.mapping.document.DocumentTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.List;

public class App3 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Author joshua = Author.builder()
                    .nickname("joshua")
                    .name("Joshua Bloch")
                    .profile("@joshbloch").build();

            Book effective = Book.builder()
                    .title("Effective Java 3rd Edition")
                    .category("Java").category("technology")
                    .language("Portuguese").language("English")
                    .author(joshua).build();

            Book puzzlers = Book.builder()
                    .title("Java™ Puzzlers: Traps, Pitfalls, and Corner Cases")
                    .category("Java").category("technology")
                    .language("Portuguese").language("English")
                    .author(joshua).build();

            Book concurrency = Book.builder()
                    .title("Java Concurrency in Practice")
                    .category("Java").category("technology")
                    .language("French").language("English")
                    .author(joshua).build();

            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            template.insert(List.of(effective, puzzlers, concurrency));

            DocumentQuery query = DocumentQuery.select().from("Book")
                            .where("author.nickname").eq("joshua")
                            .orderBy("title").asc().build();

            System.out.println("The query by API");
            template.select(query).forEach(System.out::println);

            System.out.println("The query by text");
            PreparedStatement prepare = template.prepare("select * from Book where languages = @language order by title asc ");
            prepare.bind("language", "English");

            prepare.getResult().forEach(System.out::println);

            template.delete(Book.class, effective.getId());
            template.delete(Book.class, puzzlers.getId());
            template.delete(Book.class, concurrency.getId());

        }
    }

    private App3() {
    }
}
