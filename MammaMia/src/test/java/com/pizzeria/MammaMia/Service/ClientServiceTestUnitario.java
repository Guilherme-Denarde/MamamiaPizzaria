package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Exceptions.ResourceNotFoundException;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTestUnitario {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private RegisterUserService registerUserService;

    @Mock
    private RegisterUserRepository registerUserRepository;

    @Mock
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Test
    public void testGetAllClients() {
        List<Client> clients = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();

        assertNotNull(result);
        assertEquals(clients.size(), result.size());
    }

    @Test
    public void testCreateClient_Success() {
        ClientDTO clientDTO = new ClientDTO();


//        when(registerUserRepository.findById(any())).thenReturn(Optional.of(new RegisterUser()));

        when(clientRepository.save(any(Client.class))).thenReturn(new Client());

        assertDoesNotThrow(() -> clientService.createClientFromDTO(clientDTO));
    }

    @Test
    public void testCreateClient_RegisterUserNotFound() {
        ClientDTO clientDTO = new ClientDTO();

        when(registerUserRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clientService.createClientFromDTO(clientDTO));
    }

    @Test
    public void testCreateClient_DuplicateRegisterUserId() {
        ClientDTO clientDTO = new ClientDTO();


        when(registerUserRepository.findById(any())).thenReturn(Optional.of(new RegisterUser()));

        when(clientRepository.save(any(Client.class))).thenThrow(DataIntegrityViolationException.class);

        assertThrows(EntityNotFoundException.class, () -> clientService.createClientFromDTO(clientDTO));
    }

    @Test
    public void testGetClientById_Success() {
        Long clientId = 1L;

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(new Client()));

        assertNotNull(clientService.getClientById(clientId));
    }

    @Test
    public void testGetClientById_NotFound() {
        Long clientId = 1L;


        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        assertTrue(clientService.getClientById(clientId).isEmpty());
    }

    @Test
    public void testUpdateClient_Success() {
        ClientDTO clientDTO = new ClientDTO();


        when(clientRepository.findById(clientDTO.getId())).thenReturn(Optional.of(new Client()));
        when(clientRepository.save(any(Client.class))).thenReturn(new Client());

        assertDoesNotThrow(() -> clientService.updateClientFromDTO(clientDTO));
    }

    @Test
    public void testUpdateClient_NotFound() {
        ClientDTO clientDTO = new ClientDTO();


        when(clientRepository.findById(clientDTO.getId())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> clientService.updateClientFromDTO(clientDTO));
    }

    @Test
    public void testDeleteClient_Success() {
        Long clientId = 1L;


        when(clientRepository.existsById(clientId)).thenReturn(true);

        assertTrue(clientService.deleteClient(clientId));
        verify(clientRepository, times(1)).deleteById(clientId);
    }

    @Test
    public void testDeleteClient_NotFound() {
        Long clientId = 1L;


        when(clientRepository.existsById(clientId)).thenReturn(false);

        assertFalse(clientService.deleteClient(clientId));

        verify(clientRepository, never()).deleteById(clientId);
    }

}
