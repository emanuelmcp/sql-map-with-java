package org.example.database.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findByID(String id);
    List<T> getAll();
    void save(T model);
    void update(T model);
    void delete(T model);
}
