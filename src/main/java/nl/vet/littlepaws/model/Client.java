package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Client extends ClientVetData {

    @NotBlank(message = "Date of Birth cannot be blank. ")
    @Past(message = "Date of Birth must be in the past. ")
    private LocalDate dateOfBirth;

    // relations:
    @OneToMany(mappedBy = "client")
    private List<Pet> pets;

    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;
}
