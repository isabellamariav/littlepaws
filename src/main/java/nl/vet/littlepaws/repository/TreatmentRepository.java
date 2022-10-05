package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Treatment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

    Optional<Treatment> findByName(String name);
}
