package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Client extends ClientVetData {

    private LocalDate dateOfBirth;

    // relations:
    @OneToMany(mappedBy = "client")
    private List<Pet> pets;

    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;
}
