package org.a4j.mastering.data;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
class BookDAO {

    @Inject
    private GraphTemplate template;


    public Book save(Book book) {
        Objects.requireNonNull(book, "book is required");
        return template.getTraversalVertex().hasLabel(Book.class)
                .has("name", book.getName())
                .<Book>next()
                .orElseGet(() -> template.insert(book));
    }
}
