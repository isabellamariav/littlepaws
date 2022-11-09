package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Role;
import nl.vet.littlepaws.model.RoleTypes;
import nl.vet.littlepaws.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
public class RoleUserSeeder {

    @Autowired
    RoleRepository roleRepository;

    public void run() {
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            Role user = Role
                    .builder()
                    .id(1l)
                    .name(RoleTypes.ROLE_USER)
                    .build();
            roleRepository.save(user);
            log.info("New Role: " + user.getName());
        }
    }
}