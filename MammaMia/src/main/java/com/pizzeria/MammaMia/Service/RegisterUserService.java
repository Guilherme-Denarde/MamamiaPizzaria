package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void deleteUser(Long id) {
        registerUserRepository.deleteById(id);
    }
}
