package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClientFromDTO(ClientDTO clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getRegisterUser(), clientDto.getAddress(),
                clientDto.getCpf(),
                clientDto.getName(), clientDto.getPhone());
        return clientRepository.save(client);
    }

    public Client updateClientFromDTO(ClientDTO clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getRegisterUser(), clientDto.getAddress(),
                clientDto.getCpf(),
                clientDto.getName(), clientDto.getPhone());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
