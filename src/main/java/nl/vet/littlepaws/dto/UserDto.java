package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import nl.vet.littlepaws.model.Authority;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String email;
    @JsonSerialize
    public Set<Authority> authorities;
}
