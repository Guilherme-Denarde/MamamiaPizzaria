package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.DeliveryPeopleService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<ResponseWrapper<DeliveryPeopleDTO>> getDeliveryPeopleById(@RequestParam("id") Long id) {
        return deliveryPeopleService.getDeliveryPeopleById(id)
                .map(DeliveryPeople::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("DeliveryPeople with ID " + id + " not found.")));
    }

    @PostMapping
    public ResponseEntity<DeliveryPeopleDTO> createDeliveryPeople(@RequestBody DeliveryPeopleDTO deliveryPeopleDto) {
        DeliveryPeople deliveryPeople = deliveryPeopleService.createDeliveryPeopleFromDTO(deliveryPeopleDto);
        return ResponseEntity.ok(deliveryPeople.toDTO());
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateDeliveryPeople(@RequestParam("id") Long id, @RequestBody DeliveryPeopleDTO deliveryPeopleDto) {
        try {
            if (!id.equals(Long.valueOf(deliveryPeopleDto.getId()))) {
                return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
            }
            DeliveryPeople updatedDeliveryPeople = deliveryPeopleService.updateDeliveryPeopleFromDTO(deliveryPeopleDto);
            return ResponseEntity.ok(updatedDeliveryPeople.toDTO());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("DeliveryPeople with ID " + id + " not found", 404));
        }
    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDeliveryPeople(@RequestParam("id") Long id) {

        boolean isDeleted = deliveryPeopleService.deleteDeliveryPeople(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("DeliveryPeople with ID " + id + " does not exist");
        }
    }
}
