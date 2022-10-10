package nl.vet.littlepaws.controller;

import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.mapper.ClientMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.service.AppointmentService;
import nl.vet.littlepaws.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //request type
    @GetMapping(value = "")
    public ResponseEntity<Iterable<ClientDto>> getAllClients() {
        Iterable<Client> clients = clientService.getAll();
        return ResponseEntity.ok(ClientMapper.toDtoList(clients));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> getOneClient(@PathVariable Long id) {
        Client client = clientService.read(id).get();
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

    //add
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
            Client newClient = clientService.create(ClientMapper.toEntity(clientDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newClient.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    //update
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
            clientService.update(ClientMapper.toEntity(clientDto), id);
            return ResponseEntity.noContent().build();
        }
    }

    private String test;
}
