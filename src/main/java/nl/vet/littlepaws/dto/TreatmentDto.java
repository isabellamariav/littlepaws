package nl.vet.littlepaws.dto;

import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
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

    private VeterinaryPractice veterinaryPractice;

    private List<Treatment> treatment;
}
