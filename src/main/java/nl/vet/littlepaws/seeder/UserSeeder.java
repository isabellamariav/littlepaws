package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.User;
import nl.vet.littlepaws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Component
@Slf4j
public class UserSeeder {

    @Autowired
    private UserRepository userRepository;

    public void run() {

        if (userRepository.findByUsername("Henkie").isEmpty()) {
            User user = User
                    .builder()
                    .username("henkie")
                    .password("konijn")
                    .enabled(true)
                    .email("henkie@gmail.com")
                    .build();
            userRepository.save(user);
            log.info("New User: "+ user.getUsername());
        }
    }
}