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
package org.a4j.mastering.data.travel;

import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@ApplicationScoped
class CityService {

    @Inject
    private GraphTemplate template;

    public Optional<City> findByName(String name) {
        return template.getTraversalVertex()
                .hasLabel(City.class)
                .has("name", name).next();
    }

    public City findByNameSafe(String name) {
        return template.getTraversalVertex()
                .hasLabel(City.class)
                .has("name", name).<City>next()
                .orElseThrow(() -> new IllegalStateException("Entity does not find with name: " + name));
    }

    public City save(City city) {
        return findByName(city.getName())
                .orElseGet(() -> template.insert(city));
    }

    public void load() {
        this.save(City.of("San Francisco"));
        this.save(City.of("Moscow"));
        this.save(City.of("New York"));
        this.save(City.of("São Paulo"));
        this.save(City.of("Casa Blanca"));
    }

    public Map<String, Long> getMostFunCity() {
        return template.getTraversalVertex()
                .inE(Labels.TRAVELS)
                .has(TravelerService.GOAL, TravelerService.FUN).inV()
                .<City>getResult()
                .map(City::getName)
                .collect((groupingBy(Function.identity(), counting())));
    }

    public Map<String, Long> getMostBusinessCity() {
        return template.getTraversalVertex()
                .inE(Labels.TRAVELS)
                .has(TravelerService.GOAL, TravelerService.WORK).inV()
                .<City>getResult()
                .map(City::getName)
                .collect((groupingBy(Function.identity(), counting())));
    }

    public Map<String, Long> getMostTravelCity() {
       return template.getTraversalVertex()
                .out(Labels.TRAVELS)
                .<City>getResult()
                .map(City::getName)
                .collect((groupingBy(Function.identity(), counting())));
    }
}
