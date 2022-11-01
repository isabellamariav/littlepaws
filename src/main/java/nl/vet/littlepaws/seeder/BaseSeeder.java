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
            appointmentSeeder.run();
            clientSeeder.run();
            petseeder.run();
            veterinaryPracticeSeeder.run();
            treatmentSeeder.run();
        } ;
    }
}
