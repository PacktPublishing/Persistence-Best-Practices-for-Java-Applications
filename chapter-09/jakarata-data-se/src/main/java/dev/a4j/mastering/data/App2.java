package dev.a4j.mastering.data;

import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Sort;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.List;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Hangar hangar = container.select(Hangar.class).get();

            Airplane freighters = Airplane.builder().model("Freighters")
                            .manufacturer("Boeing").nationality("United States")
                    .seats(149)
                    .build();

            Airplane max = Airplane.builder().model("Max")
                    .manufacturer("Boeing").nationality("United States")
                    .seats(149)
                    .build();

            Airplane nextGeneration = Airplane.builder().model("Next-Generation 737")
                    .manufacturer("Boeing").nationality("United States")
                    .seats(149)
                    .build();

            Airplane dreamliner = Airplane.builder().model("Dreamliner")
                    .manufacturer("Boeing").nationality("United States")
                    .seats(248)
                    .build();

            hangar.saveAll(List.of(freighters, max, nextGeneration));

            Pageable pageable = Pageable.ofSize(1)
                    .sortBy(Sort.asc("manufacturer"));

            Page<Airplane> page = hangar.findAll(pageable);

            System.out.println("The first page: " + page.content());

            Pageable nextPageable = page.nextPageable();

            Page<Airplane> page2 = hangar.findAll(nextPageable);

            System.out.println("The second page: " + page2.content());

        }
    }
}
