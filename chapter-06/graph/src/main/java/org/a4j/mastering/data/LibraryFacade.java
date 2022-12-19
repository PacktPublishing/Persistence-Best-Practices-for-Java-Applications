package org.a4j.mastering.data;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class LibraryFacade {

    @Inject
    private BookDAO bookDAO;


    @Inject
    private CategoryDAO categoryDAO;

    public void save(Book book){
        this.bookDAO.save(book);
    }

    public void save(Category category) {
        this.categoryDAO.save(category);
    }
}
