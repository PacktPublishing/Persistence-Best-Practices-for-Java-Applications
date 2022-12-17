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


import org.eclipse.jnosql.mapping.DatabaseQualifier;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Arrays;
import java.util.Optional;

public class App2 {


    public static void main(String[] args) {

        User karina = User.builder().userName("kvarel4")
                .name("Karina Varela")
                .category("Technology")
                .category("sci-fi")
                .category("History")
                .language("English")
                .language("Portuguese")
                .language("Spanish")
                .build();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            UserRepository repository = container.select(UserRepository.class, DatabaseQualifier.ofKeyValue()).get();
            repository.save(karina);
            Optional<User> user = repository.findById("kvarel4");
            System.out.println("User found: " + user);
            System.out.println("The user found: " + repository.existsById("username"));
        }
    }

    private App2() {
    }
}
