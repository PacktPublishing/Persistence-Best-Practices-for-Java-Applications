package dev.a4j.mastering.data;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MagazineRepository implements PanacheRepository<Magazine> {
    public List<Magazine> findByName(String name) {
        return list("name", name);
    }

    public List<Magazine> findByRelease(int year) {
        return list("release", year);
    }
}