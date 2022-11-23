package org.a4j.mastering.data.activerecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Model {

    private static final Map<String, Model> DATA = new HashMap<>();

    public abstract String getId();

    public void insist(){
        DATA.put(this.getId(), this);
    }

    public void delete(){
        DATA.remove(this.getId());
    }

    public void update(){
        if(DATA.get(this.getId()) == null) {
            throw new IllegalStateException("The entity cannot be updated");
        }
        DATA.put(this.getId(), this);
    }

    public static <T extends Model> T findById(String id) {
        Objects.requireNonNull(id, "id is required");
       return (T) DATA.get(id);
    }
}
