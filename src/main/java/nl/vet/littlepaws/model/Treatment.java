package nl.vet.littlepaws.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Name cannot be blank. ")
    private String name;

    @NotBlank(message = "Duration cannot be blank. Please enter the amount of minutes. ")
    @Min(5)
    private int duration;

    private double price;

    // relation:
    @ManyToOne(fetch = FetchType.EAGER)
    private VeterinaryPractice veterinaryPractice;

    @ManyToMany(mappedBy = "treatments")
    @JsonBackReference
    @JsonIgnore
    private List<Appointment> appointments;
}
