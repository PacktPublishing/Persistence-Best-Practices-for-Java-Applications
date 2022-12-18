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


import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.UUID;

public class App {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Author otavio = Author.builder().nickname("otaviojava").name("Otavio Santana").profile("@otaviojava").builder();

            Book cassandra = Book.builder()
                    .title("Apache Cassandra Horizontal scalability for Java applications")
                    .categories()
                    .author(otavio)

        }
    }

    private App() {
    }
}
