package nl.vet.littlepaws.mapper;

import nl.vet.littlepaws.dto.ClientDto;
import nl.vet.littlepaws.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static ClientDto toDto(Client client) {

        ClientDto clientDto = ClientDto.builder()
                .id(client.getId()).build();
        return clientDto;
    }

    public static List<ClientDto> toDtoList(Iterable<Client> clients) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clients) {
            clientDtos.add(ClientMapper.toDto(client));
        }
        return clientDtos;
    }

    public static Client toEntity(ClientDto clientDto) {

        Client client = Client.builder()
                .id(clientDto.getId()).build();
        return client;
    }

    public static List<Client> toEntityList(Iterable<ClientDto> clientDtos) {
        List<Client> clients = new ArrayList<>();
        for (ClientDto clientDto : clientDtos) {
            clients.add(ClientMapper.toEntity(clientDto));
        }
        return clients;
    }
}
