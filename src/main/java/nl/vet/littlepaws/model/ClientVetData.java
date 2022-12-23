package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class ClientVetData extends Base {

    private String personalTitle;

    @NotBlank(message = "First name cannot be blank. ")
    @Size(min = 2, message = "First name must be at least 2 characters. ")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank. ")
    @Size(min = 2, message = "Last name must be at least 2 characters. ")
    private String lastName;

    @NotBlank(message = "Address cannot be blank. ")
    @Size(min = 3, message = "Address must be at least 3 characters. ")
    private String address;

    @NotBlank(message = "Postal code cannot be blank. ")
    @Size(min = 4, max = 6, message = "Postal code must have between 4 and 6 characters. ")
    private String postalCode;

    @Size(min = 2, max = 50, message = "City must have between 2 and 50 characters. ")
    private String city;

    @Size(min = 6, max = 16, message = "A phone number must have between 6 and 16 numbers. ")
    private int phoneNumber;

    @Email(message="Please provide a valid email address. ")
    @Size(min = 2, message = "Email address must have at least 2 characters. ")
    @NotBlank(message = "Email address cannot be blank. ")
    private String email;
}
