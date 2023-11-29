package com.pizzeria.MammaMia.Controller;


import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.AddressService;
import com.pizzeria.MammaMia.security.config.JwtService;
import com.pizzeria.MammaMia.security.user.User;
import com.pizzeria.MammaMia.security.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/me")

    public ResponseEntity<ResponseWrapper<AddressDTO>> GetAllMe (

            HttpServletRequest request
    ) {
        final String userEmail;
        final String jwt;
        final String authHeader = request.getHeader("Authorization");
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);

        return addressService.getAllMe(user.get())
                .map(Address::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Adress  not found.")));



    }

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<ResponseWrapper<AddressDTO>> getAddressById(@RequestParam("id") Long id) {
        return addressService.getAddressById(id)
                .map(Address::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Address with ID " + id + " not found.")));
    }


    @Autowired
    private AddressService addressService;

    @GetMapping("/findAll")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses()
                .stream()
                .map(Address::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDto) {
        Address address = addressService.createAddressFromDTO(addressDto);
        return ResponseEntity.ok(address.toDTO());
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
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
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
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