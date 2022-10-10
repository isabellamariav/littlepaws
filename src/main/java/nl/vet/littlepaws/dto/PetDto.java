package nl.vet.littlepaws.dto;

import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetDto {

    @NotNull
    private long id;

    private Client client;

    private VeterinaryPractice veterinaryPractice;

    private List<Appointment> appointments;

    private List<Treatment> treatment;
}
