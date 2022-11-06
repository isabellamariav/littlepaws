package nl.vet.littlepaws.controller;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.mapper.AppointmentMapper;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.service.AppointmentService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public ResponseEntity<Iterable<AppointmentDto>> getAllAppointments() {
        Iterable<Appointment> appointments = appointmentService.getAll();
        return ResponseEntity.ok(appointmentMapper.toDtoList(appointments));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppointmentDto> getOneAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.read(id).get();
        return ResponseEntity.ok(appointmentMapper.toDto(appointment));
    }

    @PostMapping(value = "")
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
    public void deleteTreatment(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
