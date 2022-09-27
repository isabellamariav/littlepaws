package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Entity
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserData {

    @Id
    @GeneratedValue
    private long Id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private int phoneNumber;
    private String email;
}
