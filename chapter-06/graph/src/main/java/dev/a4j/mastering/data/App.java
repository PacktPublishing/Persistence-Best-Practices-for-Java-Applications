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

public final class App {

    private App() {
    }

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            LibraryFacade facade = container.select(LibraryFacade.class).get();

            Category software = facade.save(Category.of("Software"));

            Category java = facade.save(Category.of("Java"));
            Category nosql = facade.save(Category.of("NoSQL"));

            Book effectiveJava = facade.save(Book.of("Effective Java"));
            Book nosqlDistilled = facade.save(Book.of("NoSQL Distilled"));

            Person joshua = P


            facade.is(java, software);
            facade.is(nosql, software);

            facade.is(effectiveJava, software);
            facade.is(nosqlDistilled, software);

            facade.is(effectiveJava, java);
            facade.is(nosqlDistilled, nosql);


            List<String> softwareCategories =facade.getSubCategories();

            List<String> softwareBooks = facade.getSoftwareBooks();

            List<String> softwareNoSQLBooks = facade.getSoftwareNoSQL();

            System.out.println("The software categories: " + softwareCategories);
            System.out.println("The software books: " + softwareBooks);
            System.out.println("The software and NoSQL books: " + softwareNoSQLBooks);


        }
    }
}
