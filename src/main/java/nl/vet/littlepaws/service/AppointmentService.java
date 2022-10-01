package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements CRUDInterface<Appointment> {

    @Autowired
    AppointmentRepository appointmentRepository;
    public AppointmentService(){

    }

    @Override
    public Optional<Appointment> create(Appointment dto) {
        return Optional.of(appointmentRepository.save(dto));
    }

    @Override
    public Optional<Appointment> read(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Optional<Appointment> update(Appointment dto) {
        Appointment appointment = appointmentRepository.findById(dto.getId()).get();
        appointment.setPet(dto.getPet());
        appointment.setTreatment(dto.getTreatment());
        appointment.setVeterinaryPractice(dto.getVeterinaryPractice());
        return Optional.of(appointmentRepository.save(dto));
    }

    @Override
    public void delete(Appointment dto) {
        appointmentRepository.delete(dto);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
