package nl.vet.littlepaws.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {

    @Id
    @GeneratedValue
    private long Id;
    private TreatmentType type;
    private int duration;
    private double price;

    // relation:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @OneToMany(mappedBy = "treatment")
    private List<Appointment> appointments;

}
