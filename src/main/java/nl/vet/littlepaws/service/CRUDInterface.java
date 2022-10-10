package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface CRUDInterface<T>{

    Optional<T> create(T dto);
    Optional<T> read(Long id);
    Optional<T> update(T dto, Long id);

    Optional<Appointment> save(Appointment dto);

    void delete(T dto);
    Iterable<T> getAll();

}
