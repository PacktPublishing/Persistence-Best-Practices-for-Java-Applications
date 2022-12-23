package org.a4j.workshop.helidon.restaurant;

import one.microstream.integrations.cdi.types.Storage;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@ApplicationScoped
@Storage
public class Restaurant {

    private final Map<String, Item> items = new HashMap<>();

    public Collection<Item> getAll() {
        return Collections.unmodifiableCollection(this.items.values());
    }

    Item save(Item item) {
        Objects.requireNonNull(item, "item is required");
        this.items.put(item.getName(), item);
        return item;
    }

    Optional<Item> findById(String id) {
        return Optional.ofNullable(this.items.get(id));
    }

    void deleteById(String id) {
        this.items.remove(id);
    }
}
