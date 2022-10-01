package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.VeterinaryPractice;
import org.springframework.data.repository.CrudRepository;

public interface VeterinaryPracticeRepository extends CrudRepository<VeterinaryPractice, Long>  {
}
