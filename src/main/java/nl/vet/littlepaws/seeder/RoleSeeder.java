package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.ERole;
import nl.vet.littlepaws.model.Role;
import nl.vet.littlepaws.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
public class RoleSeeder {

    @Autowired
    private RoleRepository roleRepository;

    public void run() {
        if (roleRepository.findByName(ERole.ROLE_CLIENT).isEmpty()) {
            Role ROLE_CLIENT = Role
                    .builder()
                    .name(ERole.ROLE_CLIENT)
                    .build();
            roleRepository.save(ROLE_CLIENT);
            log.info("New Role: "+ ROLE_CLIENT.getName());
        }
        if (roleRepository.findByName(ERole.ROLE_VET).isEmpty()) {
            Role ROLE_VET = Role
                    .builder()
                    .name(ERole.ROLE_VET)
                    .build();
            roleRepository.save(ROLE_VET);
            log.info("New Role: "+ ROLE_VET.getName());
        }

}}
