package nl.vet.littlepaws.controller;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.PetDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.mapper.PetMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.service.AppointmentService;
import nl.vet.littlepaws.service.PetService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

    PetService petService;
    PetMapper petMapper;

    public PetController(@Lazy PetService petService, @Lazy PetMapper petMapper) {
        this.petService = petService;
        this.petMapper = petMapper;
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<PetDto>> getAllPets() {
        Iterable<Pet> pets = petService.getAll();
        return ResponseEntity.ok(petMapper.toDtoList(pets));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetDto> getOnePet(@PathVariable Long id) {
        Pet pet = petService.read(id).get();
        return ResponseEntity.ok(petMapper.toDto(pet));
    }

    //add
    @PostMapping(value = "")
    public ResponseEntity<Object> createPet(@Validated @RequestBody PetDto petDto, BindingResult br) {
        StringBuilder sb = new StringBuilder();
        if (br.hasErrors()) {
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            Pet newPet = petService.create(petMapper.toEntity(petDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newPet.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePet(@Validated @RequestBody PetDto petDto, @PathVariable Long id, BindingResult br){

        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            petService.update(petMapper.toEntity(petDto), id);
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public void deleteTreatment(@PathVariable Long id) {
        petService.delete(id);
    }
}
