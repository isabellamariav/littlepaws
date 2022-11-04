package nl.vet.littlepaws.seeder;

import lombok.extern.slf4j.Slf4j;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.ClientRepository;
import nl.vet.littlepaws.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
@Component
@Slf4j
public class AppointmentSeeder {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PetRepository petRepository;

    public void run() {
        if (appointmentRepository.findById(5L).isEmpty()) {
            Appointment chesterDierenmens = Appointment
                    .builder()
                    .date(LocalDate.parse("2023-01-05"))
                    .time(LocalTime.parse("13:00"))
//                    .pet(petRepository.findByName("Chester").get())
                    .build();
            appointmentRepository.save(chesterDierenmens);
            log.info("New Appointment: " + chesterDierenmens.getId());
        }
    }
}