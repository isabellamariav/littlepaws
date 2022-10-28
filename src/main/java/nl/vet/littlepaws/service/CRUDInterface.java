package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.*;

import java.util.List;
import java.util.Optional;

public interface CRUDInterface<T>{

    Optional<T> create(T entity);
    Optional<T> read(Long id);
    Optional<T> update(T entity, Long id);
    void delete(T entity);
    Iterable<T> getAll();
}
