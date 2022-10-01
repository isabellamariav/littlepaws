package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
