package nl.vet.littlepaws.repository;

import nl.vet.littlepaws.model.Role;
import nl.vet.littlepaws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
