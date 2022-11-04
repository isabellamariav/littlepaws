package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Pet extends Base {

    private String name;
    private String typeOfAnimal;
    private char gender;
    private LocalDate dateOfBirth;;
    private double weight;

    // relations;
    @ManyToOne()
    private Client client;

    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointment;
}
