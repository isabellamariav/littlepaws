package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.TreatmentType;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.ClientRepository;
import nl.vet.littlepaws.repository.PetRepository;
import nl.vet.littlepaws.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Component
@Slf4j
public class PetSeeder {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void run() {
        if (petRepository.findByName("Chester").isEmpty()) {
            Pet chester = Pet
                    .builder()
                    .name("Chester")
                    .typeOfAnimal("Dog")
                    .gender('M')
                    .dateOfBirth(LocalDate.parse("2015-01-05"))
                    .weight(7)
                    .client(clientRepository.findByLastName("Bermann").get())
//                    .appointment((List<Appointment>) appointmentRepository.findById(5L).get())
                    .build();
            petRepository.save(chester);
            log.info("New Pet: "+ chester.getName());
        }
    }
}
