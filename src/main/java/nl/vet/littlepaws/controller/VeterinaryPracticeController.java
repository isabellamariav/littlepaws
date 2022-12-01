package nl.vet.littlepaws.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.VeterinaryPracticeDto;
import nl.vet.littlepaws.mapper.VeterinaryPracticeMapper;
import nl.vet.littlepaws.model.VeterinaryPractice;
import nl.vet.littlepaws.service.VeterinaryPracticeService;
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
@RequestMapping(value = "/veterinarypractice")
public class VeterinaryPracticeController {

        VeterinaryPracticeService veterinaryPracticeService;
        VeterinaryPracticeMapper veterinaryPracticeMapper;

    public VeterinaryPracticeController(@Lazy VeterinaryPracticeService veterinaryPracticeService, @Lazy VeterinaryPracticeMapper veterinaryPracticeMapper) {
        this.veterinaryPracticeService = veterinaryPracticeService;
        this.veterinaryPracticeMapper = veterinaryPracticeMapper;
    }

        @GetMapping(value = "")
        @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
        public ResponseEntity<Iterable<VeterinaryPracticeDto>> getAllVeterinaryPractices() {
            Iterable<VeterinaryPractice> veterinaryPractices = veterinaryPracticeService.getAll();
            return ResponseEntity.ok(veterinaryPracticeMapper.toDtoList(veterinaryPractices));
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<VeterinaryPracticeDto> getOneVeterinaryPractice(@PathVariable Long id) {
            VeterinaryPractice veterinaryPractice = veterinaryPracticeService.read(id).get();
            return ResponseEntity.ok(veterinaryPracticeMapper.toDto(veterinaryPractice));
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Object> updateVeterinaryPractice(@Validated @RequestBody VeterinaryPracticeDto veterinaryPracticeDto, @PathVariable Long id, BindingResult br){

            StringBuilder sb = new StringBuilder();
            if(br.hasErrors()){
                for(FieldError error : br.getFieldErrors()){
                    sb.append(error.getField() + ": ");
                    sb.append(error.getDefaultMessage());
                    sb.append("\n");
                }
                return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
            } else {
                veterinaryPracticeService.update(veterinaryPracticeMapper.toEntity(veterinaryPracticeDto), id);
                return ResponseEntity.noContent().build();
            }
        }
}
