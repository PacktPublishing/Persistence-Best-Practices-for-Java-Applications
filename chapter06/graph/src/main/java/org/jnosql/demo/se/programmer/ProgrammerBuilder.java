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
package org.jnosql.demo.se.programmer;

public class ProgrammerBuilder {

    private String name;
    private String occupation;

    public ProgrammerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProgrammerBuilder occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }


    public Programmer build() {
        return new Programmer(name, occupation);
    }
}