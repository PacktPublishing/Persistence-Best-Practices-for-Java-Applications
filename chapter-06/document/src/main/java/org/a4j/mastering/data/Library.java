package org.a4j.mastering.data;

import jakarta.nosql.mapping.Repository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface Library extends Repository<Book, String> {
}
