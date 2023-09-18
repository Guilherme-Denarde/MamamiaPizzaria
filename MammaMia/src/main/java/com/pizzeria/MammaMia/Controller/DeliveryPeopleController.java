package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Service.DeliveryPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/deliveryPeople")
public class DeliveryPeopleController {

    @Autowired
    private DeliveryPeopleService deliveryPeopleService;

    @GetMapping("/findAll")
    public ResponseEntity<List<DeliveryPeopleDTO>> getAllDeliveryPeople() {
        List<DeliveryPeopleDTO> deliveryPeopleList = deliveryPeopleService.getAllDeliveryPeople()
                .stream()
                .map(DeliveryPeople::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(deliveryPeopleList);
    }

    @GetMapping
    public ResponseEntity<DeliveryPeopleDTO> getDeliveryPeopleById(@RequestParam("id") Long id) {
        return deliveryPeopleService.getDeliveryPeopleById(id)
                .map(DeliveryPeople::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<DeliveryPeopleDTO> createDeliveryPeople(@RequestBody DeliveryPeopleDTO deliveryPeopleDto) {
        DeliveryPeople deliveryPeople = deliveryPeopleService.createDeliveryPeopleFromDTO(deliveryPeopleDto);
        return ResponseEntity.ok(deliveryPeople.toDTO());
    }

    @PutMapping("/update")
    public ResponseEntity<DeliveryPeopleDTO> updateDeliveryPeople(@RequestParam("id") Long id, @RequestBody DeliveryPeopleDTO deliveryPeopleDto) {
        if (!id.equals(deliveryPeopleDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        DeliveryPeople updatedDeliveryPeople = deliveryPeopleService.updateDeliveryPeopleFromDTO(deliveryPeopleDto);
        return ResponseEntity.ok(updatedDeliveryPeople.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDeliveryPeople(@RequestParam("id") Long id) {
        deliveryPeopleService.deleteDeliveryPeople(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
