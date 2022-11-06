package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.ClientRepository;
import nl.vet.littlepaws.repository.PetRepository;
import nl.vet.littlepaws.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Configuration
@Component
@Slf4j
public class AppointmentSeeder {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;

    public void run() {
        if (appointmentRepository.findById(3L).isEmpty()) {
            Appointment chesterDierenmens = Appointment
                    .builder()
                    .id(3L)
                    .date(LocalDate.parse("2023-01-05"))
                    .time(LocalTime.parse("13:00"))
                    .treatments(List.of(treatmentRepository.findByName("Antibiotica").get()))
                    .build();
            appointmentRepository.save(chesterDierenmens);
            log.info("New Appointment: " + chesterDierenmens.getId());
        }
    }
}