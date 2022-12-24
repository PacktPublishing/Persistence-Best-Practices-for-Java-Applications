package dev.a4j.mastering.data;

import java.time.Year;

public record Car(String plate, Year year, String name, String model) {


    public static CarBuilder builder() {
        return new CarBuilder();
    }

}
