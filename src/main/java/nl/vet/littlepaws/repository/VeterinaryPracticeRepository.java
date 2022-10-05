package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.VeterinaryPractice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VeterinaryPracticeRepository extends CrudRepository<VeterinaryPractice, Long>  {

    Optional<VeterinaryPractice> findByNamePractice(String name);
}
