package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends Base {

    private LocalDateTime dateAndTime;

    // relations:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany()
    private List<Treatment> treatment;

    @ManyToOne()
    private Pet pet;
}
