package com.pizzeria.MammaMia.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Service.AddressService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AddressControllerTestIntegracao {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AddressService addressService;

    private Address address;

    @Before
    public void setUp() {
        address = new Address(null, "Rua Teste", 123, "Perto da loja", "Cidade Teste", "Estado Teste", "12345");
        address = addressService.createAddressFromDTO(address.toDTO());
    }

//    @Test
//    public void whenGetAllAddresses_thenReturnAllAddresses() throws Exception {
//        mockMvc.perform(get("/api/addresses/findAll"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(50)));
//    }

    @Test
    public void whenGetAddressById_thenReturnAddress() throws Exception {
        mockMvc.perform(get("/api/addresses")
                        .param("id", address.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.streetName", is("Rua Teste")));
    }

    @Test
    public void whenCreateAddress_thenReturnCreatedAddress() throws Exception {
        AddressDTO addressDTO = new AddressDTO(null, "Rua Nova", 789, "Perto da Nova", "Cidade Nova", "Estado Nova", "112233");

        mockMvc.perform(post("/api/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addressDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.streetName", is("Rua Nova")));
    }

    @Test
    public void whenUpdateAddress_thenReturnUpdatedAddress() throws Exception {
        AddressDTO updatedAddressDTO = new AddressDTO(address.getId(), "Rua Atualizada", 456, "Referência Atualizada", "Cidade Atualizada", "Estado Atualizado", "998877");

        mockMvc.perform(put("/api/addresses/update")
                        .param("id", address.getId().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedAddressDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.streetName", is("Rua Atualizada")));
    }

    @Test
    public void whenDeleteAddress_thenAddressShouldBeDeleted() throws Exception {
        mockMvc.perform(delete("/api/addresses/delete")
                        .param("id", address.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted successfully"));
    }
}
