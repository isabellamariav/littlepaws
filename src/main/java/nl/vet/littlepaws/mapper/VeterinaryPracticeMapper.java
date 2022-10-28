package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.VeterinaryPracticeDto;
import nl.vet.littlepaws.model.Base;
import nl.vet.littlepaws.model.VeterinaryPractice;

import java.util.List;

@AllArgsConstructor
public class VeterinaryPracticeMapper implements BaseMapperInterface<VeterinaryPractice, VeterinaryPracticeDto> {

private VeterinaryPracticeMapper veterinaryPracticeMapper;
private ClientMapper clientMapper;
private TreatmentMapper treatmentMapper;

    AppointmentMapper appointmentMapper;
    ClientMapper clientMapper;
    TreatmentMapper treatmentMapper;

    @Override
    public VeterinaryPracticeDto toDto(VeterinaryPractice veterinaryPractice) {
        return VeterinaryPracticeDto
                .builder()
                .id(veterinaryPractice.getId())
                .namePractice(veterinaryPractice.getNamePractice())
                .emergencyPhoneNumber(veterinaryPractice.getEmergencyPhoneNumber())
                .firstName(veterinaryPractice.getFirstName())
                .lastName(veterinaryPractice.getLastName())
                .address(veterinaryPractice.getAddress())
                .postalCode(veterinaryPractice.getPostalCode())
                .city(veterinaryPractice.getCity())
                .phoneNumber(veterinaryPractice.getPhoneNumber())
                .email(veterinaryPractice.getEmail())

                .appointmentDto(appointmentMapper.toDto(veterinaryPractice.getAppointments()))
                .clientDto(clientMapper.toDto(veterinaryPractice.getClients()))
                .treatmentsDto(treatmentMapper.toDtoList(veterinaryPractice.getTreatments()))
                .build();
    }

    @Override
    public List<VeterinaryPracticeDto> toDtoList(Iterable<VeterinaryPractice> veterinaryPractices) {
        return null;
    }

    @Override
    public VeterinaryPractice toEntity(VeterinaryPracticeDto veterinaryPracticeDto) {
        return VeterinaryPractice
                .builder()
                .id(veterinaryPracticeDto.getId())
                .namePractice(veterinaryPracticeDto.getNamePractice())
                .emergencyPhoneNumber(veterinaryPracticeDto.getEmergencyPhoneNumber())
                .firstName(veterinaryPracticeDto.getFirstName())
                .lastName(veterinaryPracticeDto.getLastName())
                .address(veterinaryPracticeDto.getAddress())
                .postalCode(veterinaryPracticeDto.getPostalCode())
                .city(veterinaryPracticeDto.getCity())
                .phoneNumber(veterinaryPracticeDto.getPhoneNumber())
                .email(veterinaryPracticeDto.getEmail())

                .appointments(appointmentMapper.toEntity(veterinaryPracticeDto.getAppointmentDto()))
                .client(clientMapper.toEntity(veterinaryPracticeDto.getClientDto()))
                .treatments(treatmentMapper.toEntityList(veterinaryPracticeDto.getTreatmentDto()))
                .build();
    }

    @Override
    public List<VeterinaryPractice> toEntityList(Iterable<VeterinaryPracticeDto> veterinaryPracticeDtos) {
        return null;
    }

}
