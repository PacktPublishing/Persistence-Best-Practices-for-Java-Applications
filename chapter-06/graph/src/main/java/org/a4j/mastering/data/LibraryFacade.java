package org.a4j.mastering.data;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class LibraryFacade {

    @Inject
    private BookDAO bookDAO;


    @Inject
    private CategoryDAO categoryDAO;

    public Book save(Book book) {
        return this.bookDAO.save(book);
    }

    public Category save(Category category) {
        return this.categoryDAO.save(category);
    }
}
