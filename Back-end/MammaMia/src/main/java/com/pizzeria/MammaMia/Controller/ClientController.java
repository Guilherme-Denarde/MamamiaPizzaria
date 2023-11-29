package com.pizzeria.MammaMia.Controller;


import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Exceptions.ResourceNotFoundException;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.ClientService;
import com.pizzeria.MammaMia.security.config.JwtService;
import com.pizzeria.MammaMia.security.user.User;
import com.pizzeria.MammaMia.security.user.UserRepository;
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
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/findAll")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> client = clientService.getAllClients()
                .stream()
                .map(Client::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(client);
    }



    @GetMapping("/me")

    public ResponseEntity<ResponseWrapper<ClientDTO>> GetAllMe (

            HttpServletRequest request
    ) {
        final String userEmail;
        final String jwt;
        final String authHeader = request.getHeader("Authorization");
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);

        return clientService.getAllMe(user.get())
                .map(Client::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Adress  not found.")));



    }

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<ResponseWrapper<ClientDTO>> getclientById(@RequestParam("id") Long id) {
        return clientService.getClientById(id)
                .map(Client::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("client with ID " + id + " not found.")));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<ClientDTO> createclient(@RequestBody ClientDTO clientDto) {
        Client client = clientService.createClientFromDTO(clientDto);
        return ResponseEntity.ok(client.toDTO());
    }



    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<?> updateClient(@RequestParam("id") Long id, @RequestBody ClientDTO clientDto) {
        try {
            if (!id.equals(Long.valueOf(clientDto.getId()))) {
                return ResponseEntity.badRequest().build();
            }
            Client updatedClient = clientService.updateClientFromDTO(clientDto);
            return ResponseEntity.ok(updatedClient.toDTO());
        } catch (ResourceNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public ResponseEntity<String> deleteClient(@RequestParam("id") Long id) {
        boolean isDeleted = clientService.deleteClient(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Client with ID " + id + " does not exist");
        }
    }
}
