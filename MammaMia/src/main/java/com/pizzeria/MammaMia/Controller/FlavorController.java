package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.FlavorDTO;
import com.pizzeria.MammaMia.Entity.Flavor;
import com.pizzeria.MammaMia.Service.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<FlavorDTO> getFlavorById(@RequestParam("id") Long id) {
        return flavorService.getFlavorById(id)
                .map(flavor -> new FlavorDTO(flavor.getId(), flavor.getName(), flavor.getPrice(), flavor.getIngredients()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FlavorDTO> createFlavor(@RequestBody FlavorDTO flavorDto) {
        Flavor flavor = flavorService.createFlavor(flavorDto);
        return ResponseEntity.ok(new FlavorDTO(flavor.getId(), flavor.getName(), flavor.getPrice(), flavor.getIngredients()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFlavor(@RequestParam("id") Long id) {
        flavorService.deleteFlavor(id);
        return ResponseEntity.ok().build();
    }
}
