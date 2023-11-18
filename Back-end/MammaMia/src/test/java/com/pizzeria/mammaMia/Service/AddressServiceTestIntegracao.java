//package com.pizzeria.MammaMia.Service;
//
//
//import com.pizzeria.MammaMia.Entity.Address;
//import com.pizzeria.MammaMia.Repository.AddressRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class AddressServiceTestIntegracao {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    private AddressService addressService;
//
//    @BeforeEach
//    public void setUp() {
//        addressService = new AddressService();
//        addressService.setAddressRepository(addressRepository);
//    }
//
//    @Test
//    public void whenSaveAddress_thenFindById() {
//        Address address = new Address(null, "Rua Teste", 123, "Perto da loja", "Cidade Teste", "Estado Teste", "12345");
//        entityManager.persistAndFlush(address);
//
//        Optional<Address> foundAddress = addressService.getAddressById(address.getId());
//
//        assertTrue(foundAddress.isPresent());
//        assertEquals(address.getStreetName(), foundAddress.get().getStreetName());
//    }
//
////    @Test
////    public void whenGetAllAddresses_thenReturnAllAddresses() {
////        Address address1 = new Address(null, "Rua A", 123, "Perto da A", "Cidade A", "Estado A", "12345");
////        Address address2 = new Address(null, "Rua B", 456, "Perto da B", "Cidade B", "Estado B", "67890");
////
////        entityManager.persist(address1);
////        entityManager.persist(address2);
////        entityManager.flush();
////
////        List<Address> addresses = addressService.getAllAddresses();
////
////        assertNotNull(addresses);
////        assertEquals(2, addresses.size());
////    }
//
//    @Test
//    public void whenUpdateAddress_thenReturnUpdatedAddress() {
//        Address address = new Address(null, "Rua A", 123, "Perto da A", "Cidade A", "Estado A", "12345");
//        entityManager.persistAndFlush(address);
//
//        Address newAddressData = new Address(address.getId(), "Rua B", 456, "Perto da B", "Cidade B", "Estado B", "67890");
//        addressService.updateAddressFromDTO(newAddressData.toDTO());
//
//        Address updatedAddress = entityManager.find(Address.class, address.getId());
//
//        assertEquals("Rua B", updatedAddress.getStreetName());
//        assertEquals(456, updatedAddress.getStreetNum());
//    }
//
//    @Test
//    public void whenDeleteAddress_thenAddressShouldBeDeleted() {
//        Address address = new Address(null, "Rua A", 123, "Perto da A", "Cidade A", "Estado A", "12345");
//        entityManager.persistAndFlush(address);
//
//        addressService.deleteAddress(address.getId());
//
//        Address deletedAddress = entityManager.find(Address.class, address.getId());
//        assertNull(deletedAddress);
//    }
//
//
//}