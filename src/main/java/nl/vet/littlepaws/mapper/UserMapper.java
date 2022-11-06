package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.PetDto;
import nl.vet.littlepaws.dto.UserDto;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.RoleTypes;
import nl.vet.littlepaws.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements BaseMapperInterface<User, UserDto> {

    @Override
    public UserDto toDto(User user) {
        return UserDto
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .email(user.getEmail())
                .authorities(user.getAuthorities())
                .build();
    }

    @Override
    public List<UserDto> toDtoList(Iterable<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return User
                .builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .enabled(userDto.getEnabled())
                .email(userDto.getEmail())
                .authorities(userDto.getAuthorities())
                .build();
    }

    @Override
    public List<User> toEntityList(Iterable<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for(UserDto userDto : userDtos) {
            users.add(toEntity(userDto));
        }
        return users;
    }
}
