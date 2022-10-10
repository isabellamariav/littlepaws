package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.TreatmentDto;
import nl.vet.littlepaws.model.Treatment;

import java.util.ArrayList;
import java.util.List;

public class TreatmentMapper {

    public static TreatmentDto toDto(Treatment treatment) {

        TreatmentDto treatmentDto = TreatmentDto.builder()
                .id(treatment.getId()).build();
        return treatmentDto;
    }

    public static List<TreatmentDto> toDtoList(Iterable<Treatment> treatments) {
        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        for (Treatment treatment : treatments) {
            treatmentDtos.add(TreatmentMapper.toDto(treatment));
        }
        return treatmentDtos;
    }

    public static Treatment toEntity(TreatmentDto treatmentDto) {

        Treatment treatment = Treatment.builder()
                .id(treatmentDto.getId()).build();
        return treatment;
    }

    public static List<Treatment> toEntityList(Iterable<TreatmentDto> treatmentDtos) {
        List<Treatment> treatments = new ArrayList<>();
        for (TreatmentDto treatmentDto : treatmentDtos) {
            treatments.add(TreatmentMapper.toEntity(treatmentDto));
        }
        return treatments;
    }
}
