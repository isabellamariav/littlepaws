package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VeterinaryPractice extends ClientVetData {

    private String namePractice;
    private int emergencyPhoneNumber;

    // relation:
    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Client> clients;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Treatment> treatments;
}
