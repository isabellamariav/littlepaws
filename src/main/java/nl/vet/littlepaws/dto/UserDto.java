package nl.vet.littlepaws.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import lombok.*;
import nl.vet.littlepaws.model.Role;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    @NotNull
    private long id;
    public String username;
    public String password;
    public Boolean enabled;
    public String email;
    @JsonSerialize
    public Set<Role> roles;
}
