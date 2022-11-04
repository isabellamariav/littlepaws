package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.*;

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
}
