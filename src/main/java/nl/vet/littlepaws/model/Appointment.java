package nl.vet.littlepaws.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
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

    @FutureOrPresent(message = "Date must be in the future or present. ")
    @NotBlank(message = "Date cannot be blank. ")
    private LocalDate date;
    @NotBlank(message = "Time cannot be blank. ")
    private LocalTime time;

    // relations:
    @ManyToOne()
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany()
    private List<Treatment> treatments;

    @ManyToOne()
    private Pet pet;
}
