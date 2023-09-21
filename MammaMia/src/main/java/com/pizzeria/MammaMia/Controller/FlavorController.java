package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Dto.FlavorDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.Flavor;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.FlavorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flavors")
public class FlavorController {

    @Autowired
    private FlavorService flavorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<FlavorDTO>> getAllFlavors() {
        List<FlavorDTO> flavors = flavorService.getAllFlavors()
                .stream()
                .map(flavor -> new FlavorDTO(flavor.getId(), flavor.getName(), flavor.getPrice(), flavor.getIngredients()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(flavors);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<FlavorDTO>> getFlavorById(@RequestParam("id") Long id) {
        return flavorService.getFlavorById(id)
                .map(flavor -> new FlavorDTO(flavor.getId(), flavor.getName(), flavor.getPrice(), flavor.getIngredients()))
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Flavor with ID " + id + " not found.")));
    }

    @PostMapping
    public ResponseEntity<FlavorDTO> createFlavor(@RequestBody FlavorDTO flavorDto) {
        Flavor flavor = flavorService.createFlavor(flavorDto);
        return ResponseEntity.ok(new FlavorDTO(flavor.getId(), flavor.getName(), flavor.getPrice(), flavor.getIngredients()));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateFlavor(@RequestParam("id") Long id, @RequestBody FlavorDTO flavorDTO) {
        try {
            if (!id.equals(flavorDTO.getId())) {
                return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
            }
            Flavor updatedFlavor = flavorService.updateFlavorFromDTO(flavorDTO);
            return ResponseEntity.ok(updatedFlavor.toDTO());
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Flavor with ID " + id + " not found", 404));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFlavor(@RequestParam("id") Long id) {
        boolean isDeleted = flavorService.deleteFlavor(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Flavor with ID " + id + " does not exist");
        }
    }

}
