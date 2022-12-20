package dev.a4j.mastering.data;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static dev.a4j.mastering.data.EdgeLabels.IS;

@ApplicationScoped
class LibraryFacade {

    @Inject
    private BookDAO bookDAO;

    @Inject
    private CategoryDAO categoryDAO;

    @Inject
    private GraphTemplate template;

    public Book save(Book book) {
        return this.bookDAO.save(book);
    }

    public Category save(Category category) {
        return this.categoryDAO.save(category);
    }


    public void is(Category category, Book book){
        template.edge(category, IS, book);
    }
}
