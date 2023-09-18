package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.FlavorDTO;
import com.pizzeria.MammaMia.Entity.Flavor;
import com.pizzeria.MammaMia.Repository.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlavorService {
    @Autowired
    private FlavorRepository flavorRepository;

    public List<Flavor> getAllFlavors() {
        return flavorRepository.findAll();
    }

    public Optional<Flavor> getFlavorById(Long id) {
        return flavorRepository.findById(id);
    }

    public Flavor createFlavor(FlavorDTO flavorDto) {
        Flavor flavor = new Flavor();
        flavor.setId(flavorDto.getId());
        flavor.setName(flavorDto.getFlavorName());
        flavor.setPrice(flavorDto.getFlavorPrice());
        flavor.setIngredients(flavorDto.getFlavorIngredients());
        return flavorRepository.save(flavor);
    }

    public void deleteFlavor(Long id) {
        flavorRepository.deleteById(id);
    }
}
