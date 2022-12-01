package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class ClientVetData extends Base {

    private String personalTitle;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private int phoneNumber;
    @Email
    private String email;
}
