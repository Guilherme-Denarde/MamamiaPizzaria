package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Dto.FlavorDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.Flavor;
import com.pizzeria.MammaMia.Repository.FlavorRepository;
import jakarta.persistence.EntityNotFoundException;
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


    public Flavor updateFlavorFromDTO(FlavorDTO flavorDTO) {
        Optional<Flavor> existingFlavor = flavorRepository.findById(flavorDTO.getId());
        if (existingFlavor.isPresent()) {
            Flavor flavor = existingFlavor.get();

            flavor.setName(flavorDTO.getFlavorName());
            flavor.setPrice(flavorDTO.getFlavorPrice());
            flavor.setIngredients(flavorDTO.getFlavorIngredients());

            return flavorRepository.save(flavor);
        } else {
            throw new EntityNotFoundException("Flavor com o ID " + flavorDTO.getId() + " não encontrado");
        }
    }

    public boolean deleteFlavor(Long id) {
        if (flavorRepository.existsById(id)) {
            flavorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
