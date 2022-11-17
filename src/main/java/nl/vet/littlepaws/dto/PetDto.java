package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetDto {

    @NotNull
    private long id;
    //From Pet
    private String name;
    private String typeOfAnimal;
    private String breed;
    private char gender;
    private LocalDate dateOfBirth;
    private double weight;
    //From relations
    private ClientDto clientDto;
}
