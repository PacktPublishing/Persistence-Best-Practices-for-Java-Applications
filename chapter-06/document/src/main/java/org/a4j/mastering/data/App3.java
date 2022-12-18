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
import java.util.List;

public class App3 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Author will = Author.builder()
                    .nickname("will")
                    .name("Will Larson")
                    .profile("@Lethain").build();

            Book staff = Book.builder()
                    .title("Staff Engineer")
                    .category("career").category("technology")
                    .language("Portuguese").language("English")
                    .author(will).build();

            Book elegant = Book.builder()
                    .title("An Elegant Puzzle")
                    .category("career").category("technology")
                    .language("Portuguese").language("English")
                    .author(will).build();

            Library library = container.select(Library.class).get();

            library.save(List.of(staff, elegant));

            System.out.println("The query by title: " +  library.findByTitleOrderByTitle("Staff Engineer"));

            System.out.println("Find by category: " + library.category("technology"));

        }
    }

    private App3() {
    }
}
