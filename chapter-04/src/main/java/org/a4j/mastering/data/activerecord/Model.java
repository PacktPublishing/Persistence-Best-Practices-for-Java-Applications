package org.a4j.mastering.data.activerecord;


import java.util.Objects;
import java.util.Optional;

public abstract class Model {

    private static final BookMapper MAPPER = new BookMapper();

    public abstract String getId();

    public abstract Book instance();

    public void insist() {
        this.MAPPER.insert(this.instance());
    }

    public void delete() {
        this.MAPPER.delete(this.getId());
    }

    public void update() {
        MAPPER.update(this.instance());
    }

    public static Optional<Book> findById(String id) {
        Objects.requireNonNull(id, "id is required");
        return MAPPER.findById(id);
    }
}
