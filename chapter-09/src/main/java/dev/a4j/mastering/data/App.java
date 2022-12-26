package dev.a4j.mastering.data;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.List;

public class App {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            DeveloperRepository repository = container.select(DeveloperRepository.class).get();

            Developer otavio = Developer.builder().name("Otavio Santana")
                    .city("Salvador")
                    .nickname("ptavopkava")
                    .language("Java")
                    .build();


            repository.save(otavio);

            List<Developer> java = repository.findByLanguage("Java");
            System.out.println("Java developers: "  java);
        }
    }
}
