package dev.a4j.mastering.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;


@Repository
public interface Library extends CrudRepository<Book, String> {

    List<Book> findByName(String name);
}
