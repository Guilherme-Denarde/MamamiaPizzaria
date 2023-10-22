package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddressServiceTestUnitario {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAddresses() {
        Address address = new Address(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressRepository.findAll()).thenReturn(Collections.singletonList(address));

        List<Address> addresses = addressService.getAllAddresses();

        assertNotNull(addresses);
        assertEquals(1, addresses.size());
    }

    @Test
    public void testGetAddressByIdFound() {
        Address address = new Address(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address));

        Optional<Address> result = addressService.getAddressById(1L);

        assertTrue(result.isPresent());
        assertEquals(address, result.get());
    }

    @Test
    public void testGetAddressByIdNotFound() {
        when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Address> result = addressService.getAddressById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateAddressFromDTO() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        Address address = Address.fromDTO(dto);
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address result = addressService.createAddressFromDTO(dto);

        assertNotNull(result);
        assertEquals(address, result);
    }

    @Test
    public void testUpdateAddressFromDTOExisting() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        Address address = Address.fromDTO(dto);
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address result = addressService.updateAddressFromDTO(dto);

        assertNotNull(result);
        assertEquals(address, result);
    }

    @Test
    public void testUpdateAddressFromDTOEntityNotFound() {
        AddressDTO dto = new AddressDTO(1L, "Rua A", 10, "Perto da loja B", "Cidade X", "Estado Y", "12345");
        when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> addressService.updateAddressFromDTO(dto));
    }

    @Test
    public void testDeleteAddressSuccess() {
        when(addressRepository.existsById(1L)).thenReturn(true);
        doNothing().when(addressRepository).deleteById(1L);

        boolean result = addressService.deleteAddress(1L);

        assertTrue(result);
    }

    @Test
    public void testDeleteAddressNotFound() {
        when(addressRepository.existsById(1L)).thenReturn(false);

        boolean result = addressService.deleteAddress(1L);

        assertFalse(result);
    }




}

