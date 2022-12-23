package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VeterinaryPractice extends ClientVetData {

    @NotBlank(message = "Name of the practice cannot be blank. ")
    private String namePractice;

    @NotBlank(message = "Emergency phone number cannot be blank. ")
    @Size(min = 6, max = 16, message = "Emergency phone number must have between 6 and 16 characters. ")
    private int emergencyPhoneNumber;

    // relation:
    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Client> clients;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Treatment> treatments;
}
