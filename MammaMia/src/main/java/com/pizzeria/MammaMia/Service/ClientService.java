package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Exceptions.AddressNotFoundException;
import com.pizzeria.MammaMia.Exceptions.ResourceNotFoundException;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
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

    @Autowired RegisterUserRepository registerUserRepository;

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

    public Client createClientFromDTO(ClientDTO clientDto) {
        Optional<RegisterUser> optionalRegisterUser = registerUserRepository.findById(clientDto.getRegisterUserId());
        if (optionalRegisterUser.isEmpty()) {
            throw new ResourceNotFoundException("RegisterUser with the provided ID not found");
        }
        RegisterUser registerUser = optionalRegisterUser.get();

        Optional<Address> optionalAddress = addressRepository.findById(clientDto.getAddressId());
        if (optionalAddress.isEmpty()) {
            throw new ResourceNotFoundException("Address with the provided ID not found");
        }
        Address address = optionalAddress.get();

        Client client = new Client(clientDto.getId(), registerUser, address, clientDto.getCpf(), clientDto.getName(), clientDto.getPhone());
        return clientRepository.save(client);
    }


    public Client updateClientFromDTO(ClientDTO clientDto) {

        Optional<Client> optionalExistingClient = clientRepository.findById(clientDto.getId());
        if (optionalExistingClient.isEmpty()) {
            throw new ResourceNotFoundException("Client with the provided ID not found");
        }

        Client existingClient = optionalExistingClient.get();

        existingClient.setCpf(clientDto.getCpf());
        existingClient.setName(clientDto.getName());
        existingClient.setPhone(clientDto.getPhone());

        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
