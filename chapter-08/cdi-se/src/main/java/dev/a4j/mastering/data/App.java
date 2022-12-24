
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

import one.microstream.storage.types.StorageManager;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Year;


public class App {
    public static void main(final String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            final CarService service = container.select(CarService.class).get();

            Car dodge = Car.builder()
                    .name("Dodge")
                    .model("Wagon")
                    .year(Year.of(1993))
                    .plate("JN8AE2KP7D9956349").build();

            Car ford = Car.builder()
                    .name("Ford")
                    .model("F250")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

            Car honda = Car.builder()
                    .name("Honda")
                    .model("S2000")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

            Car toyota = Car.builder()
                    .name("Toyota")
                    .model("Corolla")
                    .year(Year.of(2005))
                    .plate("WBANE73577B200053").build();

        }
        System.exit(0);
    }
}
//    Ford	F250	2005	JN8AE2KP7D9956349
//        Ford	ZX2	2001	WBANE73577B200053
//        Maybach	62	2010	WAUKFBFL7CN802943
//        Pontiac	Grand Am	1994	KM8JT3AFXFU914883
//        Aston Martin	DBS	2008	WAUBFAFL0CN191910