package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends Base {

    private LocalDate date;
    private LocalTime time;

    // relations:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany()
    private List<Treatment> treatment;

    @ManyToOne()
    private Pet pet;
}
