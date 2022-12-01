package nl.vet.littlepaws.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.mapper.ClientMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.service.AppointmentService;
import nl.vet.littlepaws.service.ClientService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*", maxAge = 3600)
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    ClientService clientService;
    ClientMapper clientMapper;

    public ClientController(@Lazy ClientService clientService, @Lazy ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping(value = "")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Iterable<ClientDto>> getAllClients() {
        Iterable<Client> clients = clientService.getAll();
        return ResponseEntity.ok(clientMapper.toDtoList(clients));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> getOneClient(@PathVariable Long id) {
        Client client = clientService.read(id).get();
        return ResponseEntity.ok(clientMapper.toDto(client));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createClient(@Validated @RequestBody ClientDto clientDto, BindingResult br) {
        StringBuilder sb = new StringBuilder();
        if (br.hasErrors()) {
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            Client newClient = clientService.create(clientMapper.toEntity(clientDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newClient.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateClient(@Validated @RequestBody ClientDto clientDto, @PathVariable Long id, BindingResult br){

        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            clientService.update(clientMapper.toEntity(clientDto), id);
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public void deleteTreatment(@PathVariable Long id) {
        clientService.delete(id);
    }
}
