package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Treatment extends Base {

    @Enumerated(EnumType.ORDINAL)
    private TreatmentType type;
    private String name;
    private int duration;
    private double price;

    // relation:
    @ManyToOne(fetch = FetchType.EAGER)
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany(mappedBy = "treatment")
    private List<Appointment> appointments;
}
