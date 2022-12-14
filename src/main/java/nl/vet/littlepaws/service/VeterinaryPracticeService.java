package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.*;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.VeterinaryPracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeterinaryPracticeService implements CRUDInterface<VeterinaryPractice>{

    @Autowired
    private VeterinaryPracticeRepository veterinaryPracticeRepository;
    public VeterinaryPracticeService(){
    }

    @Override
    public Optional<VeterinaryPractice> create(VeterinaryPractice entity) {
        return Optional.empty();
    }

    @Override
    public Optional<VeterinaryPractice> read(Long id) {
        return veterinaryPracticeRepository.findById(id);
    }

    @Override
    public Optional<VeterinaryPractice> update(VeterinaryPractice entity, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {
        veterinaryPracticeRepository.deleteById(id);
    }

    @Override
    public Iterable<VeterinaryPractice> getAll() {
        return veterinaryPracticeRepository.findAll();
    }
}
