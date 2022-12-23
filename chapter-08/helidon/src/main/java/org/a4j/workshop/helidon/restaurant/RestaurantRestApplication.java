package org.a4j.workshop.helidon.restaurant;







import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@ApplicationPath("/")
@ApplicationScoped
public class RestaurantRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(HelloController.class);
        classes.add(RestaurantController.class);
        return classes;
    }
}
