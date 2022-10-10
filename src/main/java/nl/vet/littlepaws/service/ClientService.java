package nl.vet.littlepaws.service;

import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import nl.vet.littlepaws.model.Pet;
import nl.vet.littlepaws.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements CRUDInterface<Client> {

    @Autowired
    ClientRepository clientRepository;
    public ClientService(){
    }

    @Override
    public Optional<Client> create(Client dto) {
        return Optional.of(clientRepository.save(dto));
    }

    @Override
    public Optional<Client> read(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> update(Client updateClient, Long id) {
        Client client = clientRepository.findById(id).get();
        client.setPets(updateClient.getPets());
        client.setVeterinaryPractice(updateClient.getVeterinaryPractice());
        return Optional.of(clientRepository.save(updateClient));
    }

    @Override
    public Optional<Appointment> save(Appointment dto) {
        return Optional.empty();
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
    public void delete(Client dto) {
        clientRepository.delete(dto);
    }

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }
}
