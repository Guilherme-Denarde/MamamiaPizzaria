package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployService {

    @Autowired
    private EmployRepository employRepository;

    public List<Employ> getAllEmployes() {
        return employRepository.findAll();
    }

    public Optional<Employ> getEmployById(Long id) {
        return employRepository.findById(id);
    }

    public Employ createEmployFromDTO(EmployDTO employDto) {
        Employ employ = new Employ(employDto.getId(), employDto.getRegisterUser(), employDto.getCpf(),
                employDto.getName(), employDto.getPhone(),
                employDto.getPermission(), employDto.getSalary());
        return employRepository.save(employ);
    }

    public Employ updateEmployFromDTO(EmployDTO employDto) {
        Employ employ = new Employ(employDto.getId(), employDto.getRegisterUser(), employDto.getCpf(),
                employDto.getName(), employDto.getPhone(),
                employDto.getPermission(), employDto.getSalary());
        return employRepository.save(employ);
    }

    public void deleteEmploy(Long id) {
        employRepository.deleteById(id);
    }
}

