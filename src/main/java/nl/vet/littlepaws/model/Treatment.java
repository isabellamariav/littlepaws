package nl.vet.littlepaws.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treatment extends Base {

    private TreatmentType type;
    private int duration;
    private double price;

    // relation:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany(mappedBy = "treatment")
    private List<Appointment> appointments;

}
