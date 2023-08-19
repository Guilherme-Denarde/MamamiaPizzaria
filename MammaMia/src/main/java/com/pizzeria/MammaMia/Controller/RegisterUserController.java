package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RegisterUserController {

    private final RegisterUserService registerUserService;

    @Autowired
    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RegisterUserDTO>> getAllRegisterUseres() {
        List<RegisterUserDTO> registerUseres = registerUserService.getAllUsers()
                .stream()
                .map(RegisterUser::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(registerUseres);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<RegisterUserDTO>> getRegisterUserById(@RequestParam("id") Long id) {
        return registerUserService.getUserById(id)
                .map(RegisterUser::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("RegisterUser with ID " + id + " not found.")));
    }

    @PostMapping
    public RegisterUser createUser(@RequestBody RegisterUser registerUser) {
        return registerUserService.createUser(registerUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("id") Long id) {
        registerUserService.deleteUser(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
