package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.model.Treatment;
import nl.vet.littlepaws.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Appointment> update(Appointment updateAppointment, Long id) {
        Appointment appointment = appointmentRepository.findById(id).get();
        appointment.setPet(updateAppointment.getPet());
        appointment.setTreatment(updateAppointment.getTreatment());
        appointment.setVeterinaryPractice(updateAppointment.getVeterinaryPractice());
        return Optional.of(appointmentRepository.save(updateAppointment));
    }

    @Override
    public Optional<Appointment> save(Appointment dto) {
        return Optional.empty();
    }

    @Override
    public void delete(Appointment dto) {
        appointmentRepository.delete(dto);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Client> save(Client dto) {
        return Optional.empty();
    }

    @Override
    public Optional<Pet> save(Pet dto) {
        return Optional.empty();
    }

    @Override
    public Optional<Treatment> save(Treatment dto) {
        return Optional.empty();
    }
}
