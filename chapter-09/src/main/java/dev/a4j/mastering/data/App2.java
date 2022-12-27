package dev.a4j.mastering.data;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Hangar repository = container.select(DeveloperRepository.class).get();

            Airplane freighters = Airplane.builder().model("Freighters")
                            .manufacturer("Boeing").nationality(" United States")
                    .seats(149)
                    .build();

            Airplane max = Airplane.builder().model("Max")
                    .manufacturer("Boeing").nationality(" United States")
                    .seats(149)
                    .build();

            Airplane nextGeneration = Airplane.builder().model("Next-Generation 737")
                    .manufacturer("Boeing").nationality(" United States")
                    .seats(149)
                    .build();






        }
    }
}
