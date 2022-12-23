package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends Base {

    @NotBlank(message = "Name cannot be blank. ")
    @Size(max = 20, message = "Name must have a maximum of 20 characters. ")
    private String name;

    @NotBlank(message = "Type of animal cannot be blank. ")
    private String typeOfAnimal;

    private String breed;

    @NotBlank(message = "Gender cannot be blank. Please enter F for female or M for male. ")
    private char gender;

    @NotBlank(message = "Date of birth cannot be blank. ")
    @PastOrPresent(message = "Date of birth must be past of present. ")
    private LocalDate dateOfBirth;

    private double weight;

    // relations;
    @ManyToOne()
    private Client client;

    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointment;
}
