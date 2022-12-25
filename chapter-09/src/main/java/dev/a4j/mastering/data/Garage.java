package dev.a4j.mastering.data;

import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

import java.time.Year;


@Repository
public interface Garage extends PageableRepository<Car, String> {

    Page<Car> findByYear(Year year, Pageable pageable);
}
