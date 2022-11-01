package nl.vet.littlepaws.service;


import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService implements CRUDInterface<Pet> {

    @Autowired
    private PetRepository petRepository;

    public PetService() {
    }

    @Override
    public Optional<Pet> create(Pet dto) {
        return Optional.of(petRepository.save(dto));
    }

    @Override
    public Optional<Pet> read(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Optional<Pet> update(Pet dto, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Pet dto) {
        petRepository.delete(dto);
    }

    @Override
    public Iterable<Pet> getAll() {
        return petRepository.findAll();
    }
}
