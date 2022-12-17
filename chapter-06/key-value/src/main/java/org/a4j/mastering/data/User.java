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

import java.util.List;
import java.util.Objects;


@Entity
public class User {


    @Id
    private String userName;

    private String name;

    private List<String> phones;

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public User() {
    }

    User(String userName, String name, List<String> phones) {
        this.userName = userName;
        this.name = name;
        this.phones = phones;
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
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", phones=").append(phones);
        sb.append('}');
        return sb.toString();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}
