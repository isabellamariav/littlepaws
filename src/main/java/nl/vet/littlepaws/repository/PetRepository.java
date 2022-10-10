package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PetRepository extends CrudRepository<Pet, Long> {

    Optional<Pet> findByName(String name);
}
