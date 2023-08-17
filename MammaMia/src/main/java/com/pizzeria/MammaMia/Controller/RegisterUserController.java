package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RegisterUserController {

    private final RegisterUserService registerUserService;

    @Autowired
    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @GetMapping
    public List<RegisterUser> getAllUsers() {
        return registerUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public RegisterUser getUserById(@PathVariable Long id) {
        return registerUserService.getUserById(id);
    }

    @PostMapping
    public RegisterUser createUser(@RequestBody RegisterUser registerUser) {
        return registerUserService.createUser(registerUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        registerUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
