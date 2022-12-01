package nl.vet.littlepaws.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.service.AppointmentService;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

    public AppointmentController(@Lazy AppointmentService appointmentService, @Lazy AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    AppointmentService appointmentService;
    AppointmentMapper appointmentMapper;

    @GetMapping(value = "")
    @PreAuthorize("hasRole('CLIENT') or hasRole('VET')")
    public ResponseEntity<Iterable<AppointmentDto>> getAllAppointments() {
        Iterable<Appointment> appointments = appointmentService.getAll();
        return ResponseEntity.ok(appointmentMapper.toDtoList(appointments));
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('VET')")
    public ResponseEntity<AppointmentDto> getOneAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.read(id).get();
        return ResponseEntity.ok(appointmentMapper.toDto(appointment));
    }

    @PostMapping(value = "")
    @PreAuthorize("hasRole('CLIENT') or hasRole('VET')")
    public ResponseEntity<Object> createAppointment(@Validated @RequestBody AppointmentDto appointmentDto, BindingResult br) {
        StringBuilder sb = new StringBuilder();
        if (br.hasErrors()) {
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            Appointment newAppointment = appointmentService.create(appointmentMapper.toEntity(appointmentDto)).get();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newAppointment.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('VET')")
    public ResponseEntity<Object> updateAppointment(@Validated @RequestBody AppointmentDto appointmentDto, @PathVariable Long id, BindingResult br){

        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            appointmentService.update(appointmentMapper.toEntity(appointmentDto), id);
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('VET')")
    public void deleteTreatment(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
