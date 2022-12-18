package org.a4j.mastering.data;

import jakarta.nosql.mapping.Param;
import jakarta.nosql.mapping.Query;
import jakarta.nosql.mapping.Repository;
import org.jboss.weld.environment.se.bindings.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface Library extends Repository<Book, String> {

    List<Book> findByTitle(String title);

    @Query("select * from Book where categories = @category order by title asc")
    List<Book> query(@Param("category") String category);
}
