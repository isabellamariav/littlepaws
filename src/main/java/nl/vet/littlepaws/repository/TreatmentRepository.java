package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {
}
