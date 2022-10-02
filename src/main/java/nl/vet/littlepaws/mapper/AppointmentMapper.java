package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper {
    //aggregator/mapper Dto - Entity
    public static AppointmentDto toDto(Appointment appointment) {

        AppointmentDto appointmentDto = AppointmentDto.builder()
                .id(appointment.getId()).build();
        return appointmentDto;
    }

    public static List<AppointmentDto> toDtoList(Iterable<Appointment> appointments) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDtos.add(AppointmentMapper.toDto(appointment));
        }
        return appointmentDtos;
    }

    public static Appointment toEntity(AppointmentDto appointmentDto) {

        Appointment appointment = Appointment.builder().id(appointmentDto.getId()).build();
        return appointment;
    }

    public static List<Appointment> toEntityList(Iterable<AppointmentDto> appointmentDtos) {
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentDto appointmentDto : appointmentDtos) {
            appointments.add(AppointmentMapper.toEntity(appointmentDto));
        }
        return appointments;
    }
}
