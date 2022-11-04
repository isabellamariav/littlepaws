package nl.vet.littlepaws.mapper;

import lombok.AllArgsConstructor;
import nl.vet.littlepaws.dto.AppointmentDto;
import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.model.Appointment;
import nl.vet.littlepaws.model.Client;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper implements BaseMapperInterface<Client, ClientDto> {

    private PetMapper petMapper;
    private VeterinaryPracticeMapper veterinaryPracticeMapper;

    public ClientMapper(@Lazy PetMapper petMapper, @Lazy VeterinaryPracticeMapper veterinaryPracticeMapper) {
        this.petMapper = petMapper;
        this.veterinaryPracticeMapper = veterinaryPracticeMapper;
    }

    @Override
    public ClientDto toDto(Client client) {
        return ClientDto
                .builder()
                .id(client.getId())
                .dateOfBirth(client.getDateOfBirth())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .address(client.getAddress())
                .postalCode(client.getPostalCode())
                .city(client.getCity())
                .phoneNumber(client.getPhoneNumber())
                .email(client.getEmail())

                .build();
    }

    @Override
    public List<ClientDto> toDtoList(Iterable<Client> clients) {
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client client : clients) {
            clientsDto.add(toDto(client));
        }
        return clientsDto;
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        return Client
                .builder()
                .id(clientDto.getId())
                .dateOfBirth(clientDto.getDateOfBirth())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .address(clientDto.getAddress())
                .postalCode(clientDto.getPostalCode())
                .city(clientDto.getCity())
                .phoneNumber(clientDto.getPhoneNumber())
                .email(clientDto.getEmail())

                .build();
    }

    @Override
    public List<Client> toEntityList(Iterable<ClientDto> clientDtos) {
        List<Client> clients = new ArrayList<>();
        for (ClientDto clientDto : clientDtos) {
            clients.add(toEntity(clientDto));
        }
        return clients;
    }
}
