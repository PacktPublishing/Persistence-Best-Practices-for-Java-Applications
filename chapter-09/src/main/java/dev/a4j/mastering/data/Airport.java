package dev.a4j.mastering.data;

import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Airport extends PageableRepository<Airport, String> {

    Page<Airport> findByManufacturer(String manufacturer, Pageable pageable);
}
