package com.pizzeria.MammaMia.Service;


import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public RegisterUser getUserById(Long id) {
        return registerUserRepository.findById(id).orElse(null);
    }

    public RegisterUser createUser(RegisterUser registerUser) {
        return registerUserRepository.save(registerUser);
    }

    public boolean deleteUser(Long id) {
        if (registerUserRepository.existsById(id)) {
            registerUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}