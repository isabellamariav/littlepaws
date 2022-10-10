package nl.vet.littlepaws.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseSeeder {

    @Bean
    CommandLineRunner commandLineRunner(
            ClientSeeder clientSeeder,
            TreatmentSeeder treatmentSeeder,
            VeterinaryPracticeSeeder veterinaryPracticeSeeder) {
        return arts -> {
            clientSeeder.run();
            treatmentSeeder.run();
            veterinaryPracticeSeeder.run();
        } ;
    }

}
