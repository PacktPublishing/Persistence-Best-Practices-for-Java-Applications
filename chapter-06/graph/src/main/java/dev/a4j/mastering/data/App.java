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
import java.util.List;
import java.util.Set;

public final class App {

    private App() {
    }

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            LibraryGraph graph = container.select(LibraryGraph.class).get();

            Category software = graph.save(Category.of("Software"));

            Category java = graph.save(Category.of("Java"));
            Category nosql = graph.save(Category.of("NoSQL"));

            Book effectiveJava = graph.save(Book.of("Effective Java"));
            Book nosqlDistilled = graph.save(Book.of("NoSQL Distilled"));

            Person joshua = graph.save(Person.of("Joshua Bloch"));
            Person otavio = graph.save(Person.of("Otavio Santana"));
            Person martin = graph.save(Person.of("Martin Fowler"));

            graph.is(java, software);
            graph.is(nosql, software);

            graph.is(effectiveJava, software);
            graph.is(nosqlDistilled, software);

            graph.is(effectiveJava, java);
            graph.is(nosqlDistilled, nosql);

            graph.write(joshua, effectiveJava);
            graph.write(martin, nosqlDistilled);
            graph.read(otavio, effectiveJava);
            graph.read(otavio, nosqlDistilled);

            graph.know(otavio, joshua);
            graph.know(otavio, martin);

            List<String> softwareCategories =graph.getSubCategories();

            List<String> softwareBooks = graph.getSoftwareBooks();

            List<String> softwareNoSQLBooks = graph.getSoftwareNoSQL();

            Set<Category> categories = graph.getCategories(otavio);

            System.out.println("The software categories: " + softwareCategories);
            System.out.println("The software books: " + softwareBooks);
            System.out.println("The software and NoSQL books: " + softwareNoSQLBooks);
            System.out.println("The books categories that Otavio read: " + categories);

        }
        System.exit(0);
    }
}
