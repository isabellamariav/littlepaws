package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.PetDto;
import nl.vet.littlepaws.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetMapper {

    public static PetDto toDto(Pet pet) {

        PetDto petDto = PetDto.builder()
                .id(pet.getId()).build();
        return petDto;
    }

    public static List<PetDto> toDtoList(Iterable<Pet> pets) {
        List<PetDto> petDtos = new ArrayList<>();
        for (Pet pet : pets) {
            petDtos.add(PetMapper.toDto(pet));
        }
        return petDtos;
    }

    public static Pet toEntity(PetDto petDto) {

        Pet pet = Pet.builder()
                .id(petDto.getId()).build();
        return pet;
    }

    public static List<Pet> toEntityList(Iterable<PetDto> petDtos) {
        List<Pet> pets = new ArrayList<>();
        for (PetDto petDto : petDtos) {
            pets.add(PetMapper.toEntity(petDto));
        }
        return pets;
    }
}
