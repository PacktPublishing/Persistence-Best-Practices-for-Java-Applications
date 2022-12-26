package dev.a4j.mastering.data;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Library library = container.select(Library.class).get();

            Book.builder().isbn("").title("Effective java").author("").build();

        }
    }
}
