package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.TreatmentDto;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.TreatmentRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TreatmentMapper implements BaseMapperInterface<Treatment, TreatmentDto> {

    TreatmentMapper treatmentMapper;
    VeterinaryPracticeMapper veterinaryPracticeMapper;
    TreatmentRepository treatmentRepository;

    @Override
    public TreatmentDto toDto(Treatment treatment) {
        return TreatmentDto
                .builder()
                .id(treatment.getId())
                .type(treatment.getType())
                .name(treatment.getName())
                .duration(treatment.getDuration())
                .price(treatment.getPrice())

                .treatmentsDto(treatmentMapper.toDtoList(treatment.getType()))
                .veterinaryPracticeDto(veterinaryPracticeMapper.toDto(treatment.getVeterinaryPractice()))
                .treatmentsDto(toDtoList(treatmentRepository.findAll()))

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
                .type()
                .name(treatmentDto.getName())
                .duration(treatmentDto.getDuration())
                .price(treatmentDto.getPrice())

                .veterinaryPractice(veterinaryPracticeMapper.toEntity(treatmentDto.getVeterinaryPracticeDto()))
                .treatments(toEntityList(treatmentRepository.findAll()))
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
