package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Base;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.TreatmentType;
import nl.vet.littlepaws.repository.TreatmentRepository;
import nl.vet.littlepaws.repository.VeterinaryPracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
public class TreatmentSeeder {

    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private VeterinaryPracticeRepository veterinaryPracticeRepository;

    public void run() {
        if (treatmentRepository.findByName("Antibiotica").isEmpty()) {
            Treatment antibiotica = Treatment
                    .builder()
                    .name("Antibiotica")
                    .price(40)
                    .type(TreatmentType.medication)
                    .veterinaryPractice(veterinaryPracticeRepository.findByNamePractice("Little Paws").get())
                    .duration(10)
                    .build();
            treatmentRepository.save(antibiotica);
            log.info("New Treatment: "+ antibiotica.getName());
        }
    }
}
