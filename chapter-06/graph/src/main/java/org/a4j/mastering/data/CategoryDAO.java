package org.a4j.mastering.data;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
class CategoryDAO {

    @Inject
    private GraphTemplate template;


    public Category save(Category category) {
        Objects.requireNonNull(category, "category is required");
        return template.getTraversalVertex().hasLabel(Category.class)
                .has("name", category.getName())
                .<Category>next()
                .orElseGet(() -> template.insert(category));
    }
}
