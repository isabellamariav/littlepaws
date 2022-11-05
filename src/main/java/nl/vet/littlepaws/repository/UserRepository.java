package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Treatment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Treatment, Long> {

    Optional<Treatment> findById(Long id);
}
