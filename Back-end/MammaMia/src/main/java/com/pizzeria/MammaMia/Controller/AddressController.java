package com.pizzeria.MammaMia.Controller;


import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> updateAddress(@RequestParam("id") Long id, @RequestBody AddressDTO addressDto) {
        try {
            if (!id.equals(Long.valueOf(addressDto.getId()))) {
                return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
            }
            Address updatedAddress= addressService.updateAddressFromDTO(addressDto);
            return ResponseEntity.ok(updatedAddress.toDTO());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Address with ID " + id + " not found", 404));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam("id") Long id) {
        boolean isDeleted = addressService.deleteAddress(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Address with ID " + id + " does not exist");
        }
    }
}