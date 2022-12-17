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
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class App2 {

    public static void main(String[] args) throws InterruptedException {

        User poliana = User.builder()
                .userName("poly")
                .name("Poliana Santana")
                .category("Philosophy")
                .category("History")
                .language("English")
                .language("Portuguese")
                .build();

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            KeyValueTemplate template = container.select(KeyValueTemplate.class).get();
            template.put(poliana, Duration.ofSeconds(1));
            System.out.println("The key return: " + template.get("poly", User.class));
            TimeUnit.SECONDS.sleep(2L);
            System.out.println("Entity after expired: " + template.get("poly", User.class));
            template.delete("poly");

        }
    }

    private App2() {
    }
}
