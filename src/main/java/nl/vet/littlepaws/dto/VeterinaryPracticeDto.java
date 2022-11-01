package nl.vet.littlepaws.dto;

import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.VeterinaryPractice;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeterinaryPracticeDto {

    @NotNull
    private long id;

    //from the VeterinaryPractice
    private String namePractice;
    private int emergencyPhoneNumber;

    //from the UserData
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private int phoneNumber;
    private String email;

    //from the relations
    private List<AppointmentDto> appointmentsDto;
    private List<ClientDto> clientsDto;
    private List<TreatmentDto> treatmentsDto;
}