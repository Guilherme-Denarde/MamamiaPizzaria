package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Repository.DeliveryPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPeopleService {

    @Autowired
    private DeliveryPeopleRepository deliveryPeopleRepository;

    public List<DeliveryPeople> getAllDeliveryPeople() {
        return deliveryPeopleRepository.findAll();
    }

    public Optional<DeliveryPeople> getDeliveryPeopleById(Long id) {
        return deliveryPeopleRepository.findById(id);
    }

    public DeliveryPeople createDeliveryPeopleFromDTO(DeliveryPeopleDTO deliveryPeopleDto) {
        DeliveryPeople deliveryPeople = new DeliveryPeople(deliveryPeopleDto.getId(), deliveryPeopleDto.getEmploy(),
                deliveryPeopleDto.getCpf(), deliveryPeopleDto.getName(), deliveryPeopleDto.getPhone());
        return deliveryPeopleRepository.save(deliveryPeople);
    }

    public DeliveryPeople updateDeliveryPeopleFromDTO(DeliveryPeopleDTO deliveryPeopleDto) {
        DeliveryPeople deliveryPeople = new DeliveryPeople(deliveryPeopleDto.getId(), deliveryPeopleDto.getEmploy(),
                deliveryPeopleDto.getCpf(), deliveryPeopleDto.getName(), deliveryPeopleDto.getPhone());
        return deliveryPeopleRepository.save(deliveryPeople);
    }

    public void deleteDeliveryPeople(Long id) {
        deliveryPeopleRepository.deleteById(id);
    }
}
