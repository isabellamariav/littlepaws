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
public class RoleAdminSeeder {

    @Autowired
    RoleRepository roleRepository;

    public void run() {
        if (roleRepository.findByName(RoleTypes.valueOf("ROLE_ADMIN")).isEmpty()) {
            Role admin = Role
                    .builder()
                    .id(2l)
                    .name(RoleTypes.ROLE_ADMIN)
                    .build();
            roleRepository.save(admin);
            log.info("New Role: " + admin.getName());
        }
    }
}
