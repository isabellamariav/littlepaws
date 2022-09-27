package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private long Id;
    private LocalDateTime dateAndTime;

    // relations:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @ManyToOne()
    private Treatment treatment;

    @ManyToMany()
    private Pet pet;
    //waarom/hoe container??
}
