package nl.vet.littlepaws.controller;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.TreatmentDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.mapper.TreatmentMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.service.AppointmentService;
import nl.vet.littlepaws.service.TreatmentService;
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
@RequestMapping(value = "/treatment")
public class TreatmentController {

    TreatmentService treatmentService;
    TreatmentMapper treatmentMapper;

    public TreatmentController(@Lazy TreatmentService treatmentService, @Lazy TreatmentMapper treatmentMapper) {
        this.treatmentService = treatmentService;
        this.treatmentMapper = treatmentMapper;
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<TreatmentDto>> getAllATreatments() {
        Iterable<Treatment> treatments = treatmentService.getAll();
        return ResponseEntity.ok(treatmentMapper.toDtoList(treatments));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TreatmentDto> getOneTreatment(@PathVariable Long id) {
        Treatment treatment = treatmentService.read(id).get();
        return ResponseEntity.ok(treatmentMapper.toDto(treatment));
    }

    //add
    @PostMapping(value = "")
    public ResponseEntity<Object> createTreatment(@Validated @RequestBody TreatmentDto treatmentDto, BindingResult br) {
        StringBuilder sb = new StringBuilder();
        if (br.hasErrors()) {
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            Treatment newTreatment = treatmentService.create(treatmentMapper.toEntity(treatmentDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newTreatment.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateTreatment(@Validated @RequestBody TreatmentDto treatmentDto, @PathVariable Long id, BindingResult br){

        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            treatmentService.update(treatmentMapper.toEntity(treatmentDto), id);
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public void deleteTreatment(@PathVariable Long id) {
        treatmentService.delete(id);
    }
}
