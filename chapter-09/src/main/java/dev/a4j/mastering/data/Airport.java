package dev.a4j.mastering.data;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Airport extends PageableRepository<Airport, String> {
}
