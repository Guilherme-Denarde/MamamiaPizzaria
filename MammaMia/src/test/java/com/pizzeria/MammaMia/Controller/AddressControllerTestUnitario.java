package com.pizzeria.MammaMia.Controller;
import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddressControllerTestUnitario {

    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllAddresses() {
        Address address = new Address(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressService.getAllAddresses()).thenReturn(Collections.singletonList(address));

        ResponseEntity<List<AddressDTO>> response = addressController.getAllAddresses();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testGetAddressByIdFound() {
        Address address = new Address(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressService.getAddressById(1L)).thenReturn(Optional.of(address));

        ResponseEntity<ResponseWrapper<AddressDTO>> response = addressController.getAddressById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody().getData());
    }

    @Test
    public void testGetAddressByIdNotFound() {
        when(addressService.getAddressById(1L)).thenReturn(Optional.empty());

        ResponseEntity<ResponseWrapper<AddressDTO>> response = addressController.getAddressById(1L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testCreateAddress() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        Address address = Address.fromDTO(dto);
        when(addressService.createAddressFromDTO(any(AddressDTO.class))).thenReturn(address);

        ResponseEntity<AddressDTO> response = addressController.createAddress(dto);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateAddressSuccess() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        Address address = Address.fromDTO(dto);
        when(addressService.updateAddressFromDTO(dto)).thenReturn(address);

        ResponseEntity<Object> response = addressController.updateAddress(1L, dto);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateAddressMismatchIds() {
        AddressDTO dto = new AddressDTO(2L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        ResponseEntity<Object> response = addressController.updateAddress(1L, dto);

        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateAddressNotFound() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressService.updateAddressFromDTO(dto)).thenThrow(new EntityNotFoundException());

        ResponseEntity<Object> response = addressController.updateAddress(1L, dto);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteAddressSuccess() {
        when(addressService.deleteAddress(1L)).thenReturn(true);

        ResponseEntity<String> response = addressController.deleteAddress(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Deleted successfully", response.getBody());
    }

    @Test
    public void testDeleteAddressNotFound() {
        when(addressService.deleteAddress(1L)).thenReturn(false);

        ResponseEntity<String>
                response = addressController.deleteAddress(1L);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

}
