package nl.vet.littlepaws.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends UserData {

    @Id
    @GeneratedValue
    private long Id;
    private LocalDate dateOfBirth;

    // relations:
    @OneToMany(mappedBy = "client")
    private List<Pet> pets;

    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;
}
