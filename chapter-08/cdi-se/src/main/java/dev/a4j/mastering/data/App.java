
package dev.a4j.mastering.data;

/*-
 * #%L
 * microstream-examples-cdi-javase
 * %%
 * Copyright (C) 2019 - 2021 MicroStream Software
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Year;


public class App {
    public static void main(final String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            final CarService service = container.select(CarService.class).get();

            System.out.println("The current car list: " + service.getCars());
            Car dodge = Car.builder()
                    .make("Dodge")
                    .model("Wagon")
                    .year(Year.of(1993))
                    .plate("JN8AE2KP7D9956349").build();

            Car ford = Car.builder()
                    .make("Ford")
                    .model("F250")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

            Car honda = Car.builder()
                    .make("Honda")
                    .model("S2000")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

            Car toyota = Car.builder()
                    .make("Toyota")
                    .model("Corolla")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

            service.add(ford);
            service.add(honda);
            service.add(toyota);
            service.add(dodge);
        }
        System.exit(0);
    }
}