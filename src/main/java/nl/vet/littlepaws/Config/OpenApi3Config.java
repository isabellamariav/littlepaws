package nl.vet.littlepaws.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "LittlePaws",
                version = "1",
                description = "VeterinaryPracticeApp"
        )
)
public class OpenApi3Config {

}
