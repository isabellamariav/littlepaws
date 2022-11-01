package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.AppointmentRepository;
import nl.vet.littlepaws.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentService implements CRUDInterface<Treatment> {

    @Autowired
    private TreatmentRepository treatmentRepository;
    public TreatmentService(){
    }

    @Override
    public Optional<Treatment> create(Treatment dto) {
        return Optional.of(treatmentRepository.save(dto));
    }

    @Override
    public Optional<Treatment> read(Long id) {
        return treatmentRepository.findById(id);
    }

    @Override
    public Optional<Treatment> update(Treatment updateTreatment, Long id) {
        Treatment appointment = treatmentRepository.findById(id).get();
        appointment.setVeterinaryPractice(updateTreatment.getVeterinaryPractice());
        return Optional.of(treatmentRepository.save(updateTreatment));
    }

    @Override
    public void delete(Treatment dto) {
        treatmentRepository.delete(dto);
    }

    @Override
    public Iterable<Treatment> getAll() {
        return treatmentRepository.findAll();
    }
}
