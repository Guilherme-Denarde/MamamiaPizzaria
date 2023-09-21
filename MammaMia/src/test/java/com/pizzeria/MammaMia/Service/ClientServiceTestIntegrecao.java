package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientServiceTestIntegrecao {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testCreateClient_Success() throws Exception {

        String jsonRequest = "{...}";


        ResultActions resultActions = mockMvc.perform(
                post("/api/clients")
                        .contentType("application/json")
                        .content(jsonRequest)
        );


        resultActions.andExpect(status().isBadRequest());

        long clientCount = clientRepository.count();
        assertEquals(17, clientCount);
    }


    @Test
    public void testGetClientById_Success() throws Exception {

        AddressDTO addressDTO = new AddressDTO(
                null,
                "123 Main St",
                42,     // Número da rua
                "Near the park",
                "Example City",
                "Example State",
                "12345"
        );


        Address address = convertToAddress(addressDTO);


        addressRepository.save(address);

        RegisterUserDTO registerUserDTO = new RegisterUserDTO(
                null,
                "John Doe",
                "john@example.com",
                "password123",
                "salt123",
                true,
                null

        );


        RegisterUser registerUser = convertToRegisterUser(registerUserDTO);


        registerUserRepository.save(registerUser);

        Client client = new Client();
        client.setRegisterUser(registerUser);
        client.setAddress(address);
        client.setCpf("12345678901");
        client.setName("John Doe");
        client.setPhone("123-456-7890");


        clientRepository.save(client);


        ResultActions resultActions = mockMvc.perform(get("/api/clients?id=" + client.getId()));


        resultActions.andExpect(status().isOk());


        resultActions.andExpect(jsonPath("$.data.id").value(client.getId()));
        resultActions.andExpect(jsonPath("$.data.name").value(client.getName()));

    }



    private Address convertToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setStreetName(addressDTO.getStreetName());
        address.setStreetNum(addressDTO.getStreetNum());
        address.setAddressReference(addressDTO.getAddressReference());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setPostalCode(addressDTO.getPostalCode());
        return address;
    }


    private RegisterUser convertToRegisterUser(RegisterUserDTO registerUserDTO) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setName(registerUserDTO.getName());
        registerUser.setEmail(registerUserDTO.getEmail());
        registerUser.setPassword(registerUserDTO.getPassword());
        registerUser.setSalt(registerUserDTO.getSalt());
        registerUser.setIsActive(registerUserDTO.getIsActive());
        registerUser.setLastLogin(registerUserDTO.getLastLogin());
        return registerUser;
    }



}
