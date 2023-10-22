package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterUserService {

    private final RegisterUserRepository registerUserRepository;

    @Autowired
    public RegisterUserService(RegisterUserRepository registerUserRepository) {
        this.registerUserRepository = registerUserRepository;
    }

    public List<RegisterUser> getAllUsers() {
        return registerUserRepository.findAll();
    }

    public Optional<RegisterUser> getUserById(Long id) {
        return registerUserRepository.findById(id);
    }

    public RegisterUser createUser(RegisterUser registerUser) {
        return registerUserRepository.save(registerUser);
    }


    public RegisterUser updateRegisterUserFromDTO(RegisterUserDTO registerUserDTO) {
        Optional<RegisterUser> existingRegisterUser = registerUserRepository.findById(registerUserDTO.getUserId());

        if (existingRegisterUser.isPresent()) {
            RegisterUser registerUser = existingRegisterUser.get();

            registerUser.setName(registerUserDTO.getName());
            registerUser.setEmail(registerUserDTO.getEmail());
            registerUser.setPassword(registerUserDTO.getPassword());
            registerUser.setSalt(registerUserDTO.getSalt());
            registerUser.setIsActive(registerUserDTO.getIsActive());
            registerUser.setLastLogin(registerUserDTO.getLastLogin());

            return registerUserRepository.save(registerUser);
        } else {
            throw new EntityNotFoundException("Order com o ID " + registerUserDTO.getUserId() + " não encontrado");
        }
    }

    public boolean deleteUser(Long id) {
        if (registerUserRepository.existsById(id)) {
            try {
                registerUserRepository.deleteById(id);
                return true;
            } catch (DataIntegrityViolationException e) {
                throw new EntityNotFoundException("Registro não pode ser deletado porque está sendo referenciado");
            }
        } else {
            return false;
        }
    }


}