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

import org.apache.tinkerpop.gremlin.structure.Graph;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class App {

    private App() {
    }

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            GraphTemplate template = container.select(GraphTemplate.class).get();

            template.insert(Category.of("Software"));
            template.insert(Category.of("Romance"));

            template.insert(Category.of("Java"));
            template.insert(Category.of("NoSQL"));
            template.insert(Category.of("Micro Service"));

            template.insert(Book.of("Effective Java"));
            template.insert(Book.of("NoSQL Distilled"));
            template.insert(Book.of("Migrating to Microservice Databases"));
            template.insert(Book.of("The Shack"));


            Category software = getCategory("Software", template);
            Category romance = getCategory("Romance", template);

            Category java = getCategory("Java", template);
            Category nosql = getCategory("NoSQL", template);
            Category microService = getCategory("Micro Service", template);

            Book effectiveJava = getBook("Effective Java", template);
            Book nosqlDistilled = getBook("NoSQL Distilled", template);
            Book migratingMicroservice = getBook("Migrating to Microservice Databases", template);
            Book shack = getBook("The Shack", template);



            template.edge(java, "is", software);
            template.edge(nosql, "is", software);
            template.edge(microService, "is", software);

            template.edge(effectiveJava, "is", software);
            template.edge(nosqlDistilled, "is", software);
            template.edge(migratingMicroservice, "is", software);

            template.edge(effectiveJava, "is", java);
            template.edge(nosqlDistilled, "is", nosql);
            template.edge(migratingMicroservice, "is", microService);


            template.edge(shack, "is", romance);

            List<String> softwareCategories = template.getTraversalVertex().hasLabel("Category")
                    .has("name", "Software")
                    .in("is").hasLabel("Category").<Category>getResult()
                    .map(Category::getName)
                    .collect(toList());

            List<String> softwareBooks = template.getTraversalVertex().hasLabel("Category")
                    .has("name", "Software")
                    .in("is").hasLabel("Book").<Book>getResult()
                    .map(Book::getName)
                    .collect(toList());

            List<String> sofwareNoSQLBooks = template.getTraversalVertex().hasLabel("Category")
                    .has("name", "Software")
                    .in("is")
                    .has("name", "NoSQL")
                    .in("is").<Book>getResult()
                    .map(Book::getName)
                    .collect(toList());


            System.out.println("The software categories: " + softwareCategories);
            System.out.println("The software books: " + softwareBooks);
            System.out.println("The software and NoSQL books: " + sofwareNoSQLBooks);


        }
    }

    private static Category getCategory(String name, GraphTemplate graph) {
        return graph.getTraversalVertex().hasLabel("Category")
                .has("name", name)
                .<Category>next()
                .orElseThrow(() -> new IllegalStateException("Entity does not find"));
    }

    private static Book getBook(String name, GraphTemplate graph) {
        return graph.getTraversalVertex().hasLabel("Book")
                .has("name", name)
                .<Book>next()
                .orElseThrow(() -> new IllegalStateException("Entity does not find"));
    }
}
