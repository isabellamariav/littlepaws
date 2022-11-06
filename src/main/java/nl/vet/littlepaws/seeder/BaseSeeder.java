package nl.vet.littlepaws.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseSeeder {

    @Bean
    CommandLineRunner commandLineRunner(
            AppointmentSeeder appointmentSeeder,
            ClientSeeder clientSeeder,
            PetSeeder petseeder,
            TreatmentSeeder treatmentSeeder,
            VeterinaryPracticeSeeder veterinaryPracticeSeeder) {
        return arts -> {
            clientSeeder.run();
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
