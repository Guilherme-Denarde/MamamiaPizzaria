package com.pizzeria.MammaMia.Controller;


import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/findAll")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses()
                .stream()
                .map(Address::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(addresses);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<AddressDTO>> getAddressById(@RequestParam("id") Long id) {
        return addressService.getAddressById(id)
                .map(Address::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Address with ID " + id + " not found.")));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDto) {
        Address address = addressService.createAddressFromDTO(addressDto);
        return ResponseEntity.ok(address.toDTO());
    }

    @PutMapping("/update")
    public ResponseEntity<AddressDTO> updateAddress(@RequestParam("id") Long id, @RequestBody AddressDTO addressDto) {
        if (!id.equals(addressDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Address updatedAddress = addressService.updateAddressFromDTO(addressDto);
        return ResponseEntity.ok(updatedAddress.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam("id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}