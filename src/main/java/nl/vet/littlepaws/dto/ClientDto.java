package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.VeterinaryPractice;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    @NotNull
    private long id;

    private LocalDate dateOfBirth;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private int phoneNumber;
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VeterinaryPracticeDto veterinaryPracticeDto;
}
