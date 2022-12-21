package dev.a4j.mastering.data;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;
import java.util.Objects;

import static dev.a4j.mastering.data.EdgeLabels.IS;
import static java.util.stream.Collectors.toList;

@ApplicationScoped
class LibraryGraph {


    @Inject
    private GraphTemplate template;

    public Book save(Book book) {
        Objects.requireNonNull(book, "book is required");
        return template.getTraversalVertex().hasLabel(Book.class)
                .has("name", book.getName())
                .<Book>next()
                .orElseGet(() -> template.insert(book));
    }

    public Category save(Category category) {
        Objects.requireNonNull(category, "category is required");
        return template.getTraversalVertex().hasLabel(Category.class)
                .has("name", category.getName())
                .<Category>next()
                .orElseGet(() -> template.insert(category));
    }

    public Person save(Person person) {
        Objects.requireNonNull(person, "person is required");
        return template.getTraversalVertex().hasLabel(Person.class)
                .has("name", person.getName())
                .<Person>next()
                .orElseGet(() -> template.insert(person));
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
