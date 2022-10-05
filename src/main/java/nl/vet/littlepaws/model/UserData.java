package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserData extends Base {

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private int phoneNumber;
    private String email;
}
