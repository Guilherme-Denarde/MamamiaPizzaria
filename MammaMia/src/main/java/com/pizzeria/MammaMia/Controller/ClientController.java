package com.pizzeria.MammaMia.Controller;


import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> client = clientService.getAllClients()
                .stream()
                .map(Client::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<ClientDTO>> getclientById(@RequestParam("id") Long id) {
        return clientService.getClientById(id)
                .map(Client::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("client with ID " + id + " not found.")));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createclient(@RequestBody ClientDTO clientDto) {
        Client client = clientService.createClientFromDTO(clientDto);
        return ResponseEntity.ok(client.toDTO());
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> updateClient(@RequestParam("id") Long id, @RequestBody ClientDTO clientDto) {
        if (!id.equals(clientDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Client updatedClient = clientService.updateClientFromDTO(clientDto); // corrected the capitalization here
        return ResponseEntity.ok(updatedClient.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
