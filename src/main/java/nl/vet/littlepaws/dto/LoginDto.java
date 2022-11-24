package nl.vet.littlepaws.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDto {

    private String username;

    @NotBlank
    private String password;
}
