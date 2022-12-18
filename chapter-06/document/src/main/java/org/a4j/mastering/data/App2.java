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

public class App2 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Author neal = Author.builder().nickname("neal").name("Neal Ford").profile("@neal4d").build();

            Book evolutionary = Book.builder()
                    .title("Building Evolutionary Architectures: Support Constant Change")
                    .category("architecture").category("technology")
                    .language("Portuguese").language("English")
                    .author(neal).build();

            Book fundamentals = Book.builder()
                    .title("Fundamentals of Software Architecture: An Engineering Approach")
                    .category("architecture").category("technology")
                    .language("Portuguese").language("English")
                    .author(neal).build();

            Book hard = Book.builder()
                    .title("Software Architecture: The Hard Parts: Modern Trade-Off Analyses for Distributed Architectures ")
                    .category("architecture").category("technology")
                    .language("French").language("English")
                    .author(neal).build();

            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            template.insert(List.of(evolutionary, fundamentals, hard));

            DocumentQuery query = DocumentQuery.select().from("Book")
                            .where("author.nickname").eq("neal")
                            .orderBy("title").asc().build();

            System.out.println("The query by API");
            template.select(query).forEach(System.out::println);

            System.out.println("The query by text");
            PreparedStatement prepare = template.prepare("select * from Book where languages = @language order by title asc ");
            prepare.bind("language", "English");

            prepare.getResult().forEach(System.out::println);

            template.delete(Book.class, evolutionary.getId());
            template.delete(Book.class, fundamentals.getId());
            template.delete(Book.class, hard.getId());

        }
    }

    private App2() {
    }
}
