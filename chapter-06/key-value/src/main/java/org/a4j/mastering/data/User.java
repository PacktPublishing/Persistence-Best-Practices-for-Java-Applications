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


import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class User {


    @Id
    private String userName;

    private String name;

    private Set<String> languages;

    private Set<String> categories;

    public User() {
        this.languages = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public Set<String> getLanguages() {
        return Collections.unmodifiableSet(languages);
    }

    public Set<String> getCategories() {
        return Collections.unmodifiableSet(categories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", languages=" + languages +
                ", categories=" + categories +
                '}';
    }
}
