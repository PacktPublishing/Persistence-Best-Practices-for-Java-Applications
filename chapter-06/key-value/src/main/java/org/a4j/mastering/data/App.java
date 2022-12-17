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


import jakarta.nosql.mapping.keyvalue.KeyValueTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Arrays;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        User otavio = User.builder().userName("otaviojava")
                .name("Otavio Santana")
                .category("Technology")
                .category("Philosophy")
                .category("History")
                .language("English")
                .language("Portuguese")
                .language("French").build();

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            KeyValueTemplate template = container.select(KeyValueTemplate.class).get();
            User userSaved = template.put(otavio);
            System.out.println("User saved: " + userSaved);
            Optional<User> user = template.get("otaviojava", User.class);
            System.out.println("Entity found: " + user);

        }
    }

    private App() {
    }
}
