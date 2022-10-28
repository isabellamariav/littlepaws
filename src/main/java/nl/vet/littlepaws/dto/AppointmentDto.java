package nl.vet.littlepaws.dto;

import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.model.VeterinaryPractice;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {

    @NotNull
    private long id;
    //From Appointment
    private LocalDateTime dateAndTime;
    //From relations
    private VeterinaryPracticeDto veterinaryPracticeDto;
    private List<TreatmentDto> treatmentsDto;
    private PetDto petDto;
}
