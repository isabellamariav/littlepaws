package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.TreatmentType;
import nl.vet.littlepaws.model.VeterinaryPractice;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreatmentDto {

    @NotNull
    private long id;
    private TreatmentType type;
    private String name;
    private int duration;
    private double price;

    @JsonBackReference
    private VeterinaryPracticeDto veterinaryPracticeDto;
    private List<TreatmentDto> treatmentsDto;
}
