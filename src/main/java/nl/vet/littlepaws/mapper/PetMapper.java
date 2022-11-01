package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.dto.PetDto;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetMapper implements BaseMapperInterface<Pet, PetDto> {


    private ClientMapper clientMapper;
    private AppointmentMapper appointmentMapper;

    public PetMapper(@Lazy ClientMapper clientMapper, @Lazy AppointmentMapper appointmentMapper) {
        this.clientMapper = clientMapper;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public PetDto toDto(Pet pet) {
        return PetDto
                .builder()
                .id(pet.getId())
                .name(pet.getName())
                .typeOfAnimal(pet.getTypeOfAnimal())
                .gender(pet.getGender())
                .age(pet.getAge())
                .weight(pet.getWeight())

                .clientDto(clientMapper.toDto(pet.getClient()))
//                .appointmentDtos(appointmentMapper.toDtoList(pet.getAppointment()))

                .build();
    }

    @Override
    public List<PetDto> toDtoList(Iterable<Pet> pets) {
        List<PetDto> petsDto = new ArrayList<>();
        for (Pet pet : pets) {
            petsDto.add(toDto(pet));
        }
        return petsDto;
    }

    @Override
    public Pet toEntity(PetDto petDto) {
        return Pet
                .builder()
                .id(petDto.getId())
                .name(petDto.getName())
                .typeOfAnimal(petDto.getTypeOfAnimal())
                .gender(petDto.getGender())
                .age(petDto.getAge())
                .weight(petDto.getWeight())

                .client(clientMapper.toEntity(petDto.getClientDto()))
                .appointment(appointmentMapper.toEntityList(petDto.getAppointmentDtos()))

                .build();
    }

    @Override
    public List<Pet> toEntityList(Iterable<PetDto> petDtos) {
        List<Pet> pets = new ArrayList<>();
        for (PetDto petDto : petDtos) {
            pets.add(toEntity(petDto));
        }
        return pets;
    }
}
