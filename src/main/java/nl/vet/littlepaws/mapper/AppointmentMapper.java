package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.dto.VeterinaryPracticeDto;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements BaseMapperInterface<Appointment, AppointmentDto> {


    private TreatmentMapper treatmentMapper;
    private PetMapper petMapper;

    AppointmentMapper(@Lazy TreatmentMapper treatmentMapper, @Lazy PetMapper petMapper, @Lazy VeterinaryPracticeMapper veterinaryPracticeMapper){
        this.treatmentMapper = treatmentMapper;
        this.petMapper = petMapper;
    }

    @Override
    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto
                .builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .time(appointment.getTime())

                .treatmentsDto(treatmentMapper.toDtoList(appointment.getTreatments()))
//                .petDto(petMapper.toDto(appointment.getPet()))

                .build();
    }

    @Override
    public List<AppointmentDto> toDtoList(Iterable<Appointment> appointments) {
        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentsDto.add(toDto(appointment));
        }
        return appointmentsDto;
    }

    @Override
    public Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment
                .builder()
                .id(appointmentDto.getId())
                .date(appointmentDto.getDate())
                .time(appointmentDto.getTime())

                .treatments(treatmentMapper.toEntityList(appointmentDto.getTreatmentsDto()))
                .pet(petMapper.toEntity(appointmentDto.getPetDto()))

                .build();
    }

    @Override
    public List<Appointment> toEntityList(Iterable<AppointmentDto> appointmentDtos) {
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentDto appointmentDto : appointmentDtos) {
            appointments.add(toEntity(appointmentDto));
        }
        return appointments;
    }
}
