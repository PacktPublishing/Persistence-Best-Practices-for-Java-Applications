package org.a4j.mastering.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    public void shouldReturnNPEWhenParameterIsNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                Email.of(null));
    }

}