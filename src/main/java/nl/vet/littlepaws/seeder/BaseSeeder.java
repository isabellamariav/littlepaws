package nl.vet.littlepaws.seeder;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.PetRepository;
import nl.vet.littlepaws.repository.VeterinaryPracticeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BaseSeeder {

    AppointmentRepository appointmentRepository;
    PetRepository petRepository;
    VeterinaryPracticeRepository veterinaryPracticeRepository;

    @Bean
    CommandLineRunner commandLineRunner(
            AppointmentSeeder appointmentSeeder,
            ClientSeeder clientSeeder,
            PetSeeder petseeder,
            RoleSeeder roleSeeder,
            TreatmentSeeder treatmentSeeder,
            VeterinaryPracticeSeeder veterinaryPracticeSeeder) {
        return arts -> {
            roleSeeder.run();
            clientSeeder.run();
            treatmentSeeder.run();
            appointmentSeeder.run();
            petseeder.run();

            veterinaryPracticeSeeder.run();

            try {
                Appointment appointment = appointmentRepository.findById(3L).get();
                appointment.setPet(petRepository.findByName("Chester").get());
                appointment.setVeterinaryPractice(veterinaryPracticeRepository.findByNamePractice("Little Paws").get());
                appointmentRepository.save(appointment);
            }catch(Exception e){
                System.out.println("[Seeder] - Failed to attach data to appointment: " + e.getMessage());
            }
        };
    }
}