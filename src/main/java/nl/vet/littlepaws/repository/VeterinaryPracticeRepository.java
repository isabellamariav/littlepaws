package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinaryPracticeRepository extends CrudRepository<VeterinaryPractice, Long> {

    Optional<VeterinaryPractice> findByNamePractice(String namePractice);
}
