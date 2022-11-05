package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.VeterinaryPractice;
import nl.vet.littlepaws.repository.VeterinaryPracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
public class VeterinaryPracticeSeeder {

    @Autowired
    private VeterinaryPracticeRepository veterinaryPracticeRepository;

    public void run() {
        if (veterinaryPracticeRepository.findByNamePractice("Little Paws").isEmpty()) {
            VeterinaryPractice littlePaws = VeterinaryPractice
                    .builder()
                    .namePractice("Little Paws")
                    .address("Kattenlaan 1")
                    .postalCode("2221 AA")
                    .city("Katwijk aan Zee")
                    .email("vet@littlepaws.com")
                    .personalTitle("Dokter")
                    .firstName("Ben")
                    .lastName("Gaal")
                    .phoneNumber(0512123456)
                    .emergencyPhoneNumber(0512654321)
                    .build();
            veterinaryPracticeRepository.save(littlePaws);
            log.info("New VeterinaryPractice: "+ littlePaws.getNamePractice());
        }
    }
}
