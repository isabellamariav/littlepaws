package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.dto.VeterinaryPracticeDto;
import nl.vet.littlepaws.model.Base;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.VeterinaryPractice;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VeterinaryPracticeMapper implements BaseMapperInterface<VeterinaryPractice, VeterinaryPracticeDto> {


    private AppointmentMapper appointmentMapper;
    private ClientMapper clientMapper;
    private TreatmentMapper treatmentMapper;

    public VeterinaryPracticeMapper(@Lazy AppointmentMapper appointmentMapper, @Lazy ClientMapper clientMapper, @Lazy TreatmentMapper treatmentMapper) {
        this.appointmentMapper = appointmentMapper;
        this.clientMapper = clientMapper;
        this.treatmentMapper = treatmentMapper;
    }

    @Override
    public VeterinaryPracticeDto toDto(VeterinaryPractice veterinaryPractice) {
        return VeterinaryPracticeDto
                .builder()
                .id(veterinaryPractice.getId())
                .namePractice(veterinaryPractice.getNamePractice())
                .emergencyPhoneNumber(veterinaryPractice.getEmergencyPhoneNumber())
                .personalTitle(veterinaryPractice.getPersonalTitle())
                .firstName(veterinaryPractice.getFirstName())
                .lastName(veterinaryPractice.getLastName())
                .address(veterinaryPractice.getAddress())
                .postalCode(veterinaryPractice.getPostalCode())
                .city(veterinaryPractice.getCity())
                .phoneNumber(veterinaryPractice.getPhoneNumber())
                .email(veterinaryPractice.getEmail())

                .appointmentsDto(appointmentMapper.toDtoList(veterinaryPractice.getAppointments()))
                .clientsDto(clientMapper.toDtoList(veterinaryPractice.getClients()))
                .treatmentsDto(treatmentMapper.toDtoList(veterinaryPractice.getTreatments()))
                .build();
    }

    @Override
    public List<VeterinaryPracticeDto> toDtoList(Iterable<VeterinaryPractice> veterinaryPractices) {
        List<VeterinaryPracticeDto> veterinaryPracticeDtos = new ArrayList<>();
        for (VeterinaryPractice veterinaryPractice : veterinaryPractices) {
            veterinaryPracticeDtos.add(toDto(veterinaryPractice));
        }
        return veterinaryPracticeDtos;
    }

    @Override
    public VeterinaryPractice toEntity(VeterinaryPracticeDto veterinaryPracticeDto) {
        return VeterinaryPractice
                .builder()
                .id(veterinaryPracticeDto.getId())
                .namePractice(veterinaryPracticeDto.getNamePractice())
                .emergencyPhoneNumber(veterinaryPracticeDto.getEmergencyPhoneNumber())
                .personalTitle(veterinaryPracticeDto.getPersonalTitle())
                .firstName(veterinaryPracticeDto.getFirstName())
                .lastName(veterinaryPracticeDto.getLastName())
                .address(veterinaryPracticeDto.getAddress())
                .postalCode(veterinaryPracticeDto.getPostalCode())
                .city(veterinaryPracticeDto.getCity())
                .phoneNumber(veterinaryPracticeDto.getPhoneNumber())
                .email(veterinaryPracticeDto.getEmail())

                .appointments(appointmentMapper.toEntityList(veterinaryPracticeDto.getAppointmentsDto()))
                .clients(clientMapper.toEntityList(veterinaryPracticeDto.getClientsDto()))
                .treatments(treatmentMapper.toEntityList(veterinaryPracticeDto.getTreatmentsDto()))
                .build();
    }

    @Override
    public List<VeterinaryPractice> toEntityList (Iterable<VeterinaryPracticeDto> veterinaryPracticeDtos) {
        List<VeterinaryPractice> veterinaryPractices = new ArrayList<>();
        for (VeterinaryPracticeDto veterinaryPracticeDto : veterinaryPracticeDtos) {
            veterinaryPractices.add(toEntity(veterinaryPracticeDto));
        }
        return veterinaryPractices;
    }

}
