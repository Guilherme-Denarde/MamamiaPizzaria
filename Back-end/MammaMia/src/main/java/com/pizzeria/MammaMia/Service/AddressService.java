package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.security.user.User;
import com.pizzeria.MammaMia.security.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired @Setter
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepositor;

    @Autowired
    private ClientRepository clientRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address createAddressFromDTO(AddressDTO addressDto) {
        Address address = new Address(addressDto.getId(), addressDto.getStreetName(), addressDto.getStreetNum(),
                addressDto.getAddressReference(), addressDto.getCity(),
                addressDto.getState(), addressDto.getPostalCode());
        return addressRepository.save(address);
    }

    public Address updateAddressFromDTO(AddressDTO addressDto) {
        Optional<Address> existingAddress = addressRepository.findById(Long.valueOf(addressDto.getId()));

        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();


            address.setStreetName(addressDto.getStreetName());
            address.setStreetNum(addressDto.getStreetNum());
            address.setAddressReference(addressDto.getAddressReference());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setPostalCode(addressDto.getPostalCode());

            return addressRepository.save(address);
        } else {
            throw new EntityNotFoundException("Address com o ID " + addressDto.getId() + " não encontrado");
        }
    }

    public boolean deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Optional<Address> getAllMe(User user) {
       Optional<Client> client =  clientRepository.findByUser(user);
       Optional<Address>  addres =  Optional.of( client.get().getAddress() );

            return addres;



    }
}

