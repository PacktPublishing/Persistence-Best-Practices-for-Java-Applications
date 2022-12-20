package dev.a4j.mastering.data;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

import static dev.a4j.mastering.data.EdgeLabels.IS;
import static java.util.stream.Collectors.toList;

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


    public void is(Book book, Category category){
        template.edge(category, IS, book);
    }

    public void is(Category category, Category categoryB){
        template.edge(category, IS, categoryB);
    }

    List<String> getSubCategories(){
       return template.getTraversalVertex()
                .hasLabel(Category.class)
                .has("name", "Software")
                .in(IS)
               .hasLabel(Category.class).<Category>getResult()
                .map(Category::getName)
                .collect(toList());
    }

    List<String> getSoftwareBooks() {
        return template.getTraversalVertex()
                .hasLabel(Category.class)
                .has("name", "Software")
                .in(IS).hasLabel(Book.class).<Book>getResult()
                .map(Book::getName)
                .collect(toList());
    }

    List<String> getSoftwareNoSQL() {
        return template.getTraversalVertex().hasLabel(Category.class)
                .has("name", "Software")
                .in(IS)
                .has("name", "NoSQL")
                .in(IS).<Book>getResult()
                .map(Book::getName)
                .collect(toList());
    }
}
