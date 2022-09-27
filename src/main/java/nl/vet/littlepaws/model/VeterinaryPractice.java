package nl.vet.littlepaws.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeterinaryPractice extends UserData {

    @Id
    @GeneratedValue
    private long Id;
    private String nameClinic;
    private int emergencyPhoneNumber;

    // relation:
    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Client> clients;

    @OneToMany(mappedBy = "veterinaryPractice")
    private List<Treatment> treatments;
}
