package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

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
        Address address = new Address(addressDto.getId(), addressDto.getStreetName(), addressDto.getStreetNum(),
                addressDto.getAddressReference(), addressDto.getCity(),
                addressDto.getState(), addressDto.getPostalCode());
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}

