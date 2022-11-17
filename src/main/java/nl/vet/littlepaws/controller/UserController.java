package nl.vet.littlepaws.controller;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.dto.UserDto;
import nl.vet.littlepaws.mapper.ClientMapper;
import nl.vet.littlepaws.mapper.UserMapper;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.User;
import nl.vet.littlepaws.service.ClientService;
import nl.vet.littlepaws.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

    UserService userService;
    UserMapper usermapper;

    public UserController(UserService userService, UserMapper usermapper) {
        this.userService = userService;
        this.usermapper = usermapper;
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<UserDto>> getAllUsers() {
        Iterable<User> users = UserService.getAll();
        return ResponseEntity.ok(UserMapper.toDtoList(users));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long id) {
        User user = userService.read(id).get();
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@Validated @RequestBody UserDto userDto, BindingResult br) {
        StringBuilder sb = new StringBuilder();
        if (br.hasErrors()) {
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            User newUser = userService.create(UserMapper.toEntity(userDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@Validated @RequestBody UserDto UserDto, @PathVariable Long id, BindingResult br){

        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            userService.update(UserMapper.toEntity(userDto), id);
            return ResponseEntity.noContent().build();
        }
    }

    private String test;
}