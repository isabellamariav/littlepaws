package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.TreatmentType;
import nl.vet.littlepaws.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Configuration
@Component
@Slf4j
public class ClientSeeder {

    @Autowired
    private ClientRepository clientRepository;

    public void run() {
        if (clientRepository.findByLastName("Bermann").isEmpty()) {
            Client dierenmens = Client
                    .builder()
                    .firstName("Do")
                    .lastName("Bermann")
                    .dateOfBirth(LocalDate.parse("1989-03-16"))
                    .address("Hondenlaan 10")
                    .postalCode("2221 AA")
                    .city("Kat aan Zee")
                    .email("dobermann@gmail.com")
                    .phoneNumber(0611111111)
                    .build();
            clientRepository.save(dierenmens);
            log.info("New Client: "+ dierenmens.getLastName());
        }
    }
}
