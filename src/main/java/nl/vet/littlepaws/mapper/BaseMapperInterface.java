package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;

import java.util.ArrayList;
import java.util.List;

public interface BaseMapperInterface<Entity, Dto> {

    Dto toDto(Entity entity);
    List<Dto> toDtoList(Iterable<Entity> entities);

    Entity toEntity(Dto dto);
    List<Entity> toEntityList(Iterable<Dto> dtos);
}
