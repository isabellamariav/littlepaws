package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.TreatmentDto;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.TreatmentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TreatmentMapper implements BaseMapperInterface<Treatment, TreatmentDto> {

    private VeterinaryPracticeMapper veterinaryPracticeMapper;
    private AppointmentMapper appointmentMapper;

    public TreatmentMapper(@Lazy VeterinaryPracticeMapper veterinaryPracticeMapper, @Lazy AppointmentMapper appointmentMapper) {
        this.veterinaryPracticeMapper = veterinaryPracticeMapper;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public TreatmentDto toDto(Treatment treatment) {
        return TreatmentDto
                .builder()
                .id(treatment.getId())
                .type(treatment.getType())
                .name(treatment.getName())
                .duration(treatment.getDuration())
                .price(treatment.getPrice())

                .build();
    }

    @Override
    public List<TreatmentDto> toDtoList(Iterable<Treatment> treatments) {
        List<TreatmentDto> treatmentsDto = new ArrayList<>();
        for (Treatment treatment : treatments) {
            treatmentsDto.add(toDto(treatment));
        }
        return treatmentsDto;
    }

    @Override
    public Treatment toEntity(TreatmentDto treatmentDto) {
        return Treatment
                .builder()
                .id(treatmentDto.getId())
                .type(treatmentDto.getType())
                .name(treatmentDto.getName())
                .duration(treatmentDto.getDuration())
                .price(treatmentDto.getPrice())

                .build();
    }

    @Override
    public List<Treatment> toEntityList(Iterable<TreatmentDto> treatmentDtos) {
        List<Treatment> treatments = new ArrayList<>();
        for (TreatmentDto treatmentDto : treatmentDtos) {
            treatments.add(toEntity(treatmentDto));
        }
        return treatments;
    }
}
