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

//    public RegisterUser createUser(RegisterUser registerUser) {
//        try {
//            return registerUserRepository.save(registerUser);
//        } catch (DataIntegrityViolationException ex) {
//            if (ex.getMessage().contains("name")) {
//                throw new IllegalArgumentException("A user with this name already exists.");
//            } else if (ex.getMessage().contains("email")) {
//                throw new IllegalArgumentException("A user with this email already exists.");
//            }
//            throw new RuntimeException("Error creating user.");
//        }
//    }
public RegisterUser createUser(RegisterUser registerUser) {
    // Check if a user with the same name already exists
    Optional<RegisterUser> existingUserWithName = registerUserRepository.findByName(registerUser.getName());
    if (existingUserWithName.isPresent()) {
        throw new IllegalArgumentException("A user with this name already exists.");
    }

    // Check if a user with the same email already exists
    Optional<RegisterUser> existingUserWithEmail = registerUserRepository.findByEmail(registerUser.getEmail());
    if (existingUserWithEmail.isPresent()) {
        throw new IllegalArgumentException("A user with this email already exists.");
    }

    return registerUserRepository.save(registerUser);
}


    public RegisterUser updateRegisterUserFromDTO(RegisterUserDTO registerUserDTO) {
        Optional<RegisterUser> existingRegisterUser = registerUserRepository.findById(Long.valueOf(registerUserDTO.getUserId()));

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
                throw new IllegalStateException("Registro não pode ser deletado porque está sendo referenciado");
            }
        } else {
            throw new EntityNotFoundException("User with ID " + id + " not found.");
        }
    }
    public Optional<RegisterUser> verifyUserCredentials(String email, String password) {
        Optional<RegisterUser> userOptional = registerUserRepository.findByEmail(email);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional;
        }
        return Optional.empty();
    }
}
