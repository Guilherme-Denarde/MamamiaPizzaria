package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Exceptions.ResourceNotFoundException;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.security.user.User;
import com.pizzeria.MammaMia.security.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private  AddressRepository addressRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClientFromDTO(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setUser(clientDTO.getRegisterUserId());
        client.setAddress(clientDTO.getAddressId());
        client.setCpf(clientDTO.getCpf());
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());

        if (clientDTO.getRegisterUserId() != null) {
            User registerUser = userRepository.findById(clientDTO.getRegisterUserId().getId())
                    .orElseThrow(() -> new EntityNotFoundException("RegisterUser não encontrado"));
            client.setUser(registerUser);
        }
        if (clientDTO.getAddressId() != null) {
            Address address = addressRepository.findById(Long.valueOf(clientDTO.getAddressId().getId()))
                    .orElseThrow(() -> new EntityNotFoundException("Addres não encontrado"));
            client.setAddress(address);
        }

        try {
            return clientRepository.save(client);
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotFoundException("Já existe um cliente com esse RegisterUser ID "+clientDTO.getRegisterUserId().getId());
        }
    }


    public Client updateClientFromDTO(ClientDTO clientDto) {

        Optional<Client> optionalExistingClient = clientRepository.findById(Long.valueOf(clientDto.getId()));
        if (optionalExistingClient.isEmpty()) {
            throw new ResourceNotFoundException("Client with the provided ID not found");
        }

        Client existingClient = optionalExistingClient.get();

        existingClient.setCpf(clientDto.getCpf());
        existingClient.setName(clientDto.getName());
        existingClient.setPhone(clientDto.getPhone());

        return clientRepository.save(existingClient);
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Client> getAllMe(User user) {

        Optional<Client> client = clientRepository.findByUser(user);
        return client;

    }
}
