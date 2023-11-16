package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.EmployRepository;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployService {

    @Autowired
    private EmployRepository employRepository;

    @Autowired
    private RegisterUserRepository registerUserRepository;


    public List<Employ> getAllEmployes() {
        return employRepository.findAll();
    }

    public Optional<Employ> getEmployById(Long id) {
        return employRepository.findById(id);
    }

    public Employ createEmployFromDTO(EmployDTO employDto) {
        RegisterUser registerUser = registerUserRepository
                .findById(Long.valueOf(employDto.getRegisterUser().getUserId()))
                .orElseThrow(() -> new EntityNotFoundException("RegisterUser not found"));

        Employ employ = new Employ(employDto.getId(), registerUser, employDto.getCpf(),
                employDto.getName(), employDto.getPhone(),
                employDto.getPermission(), employDto.getSalary());

        return employRepository.save(employ);
    }

    public Employ updateEmployFromDTO(EmployDTO employDto) {
        Optional<Employ> existingEmploy = employRepository.findById(Long.valueOf(employDto.getId()));
        if (existingEmploy.isPresent()) {
            Employ employ = existingEmploy.get();

            employ.setCpf(employDto.getCpf());
            employ.setName(employDto.getName());
            employ.setPhone(employDto.getPhone());
            employ.setPermission(employDto.getPermission());
            employ.setSalary(employDto.getSalary());

            return employRepository.save(employ);
        } else {
            throw new EntityNotFoundException("Employ com o ID " + employDto.getId() + " não encontrado");
        }
    }
    public boolean deleteEmploy(Long id) {
        if (registerUserRepository.existsById(id)) {
            registerUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
