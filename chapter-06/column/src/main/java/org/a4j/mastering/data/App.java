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


import org.eclipse.jnosql.mapping.cassandra.column.CassandraTemplate;
import jakarta.nosql.mapping.column.ColumnTemplate;
import jakarta.nosql.column.ColumnQuery;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Arrays;
import java.util.Optional;

import static jakarta.nosql.column.ColumnQuery.select;


public class App {


    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate template =  container.select(CassandraTemplate.class).get();

        }
    }

    private App() {}
}
