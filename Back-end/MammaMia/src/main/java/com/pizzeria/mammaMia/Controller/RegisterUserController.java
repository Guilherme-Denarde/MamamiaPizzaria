//package com.pizzeria.MammaMia.Controller;
//
//import com.pizzeria.MammaMia.Dto.OrderDTO;
//import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
//import com.pizzeria.MammaMia.Entity.*;
//import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
//import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
//import com.pizzeria.MammaMia.Response.ResponseWrapper;
//import com.pizzeria.MammaMia.Service.RegisterUserService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//import java.util.Optional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/users")
//public class RegisterUserController {
//
//    private final RegisterUserService registerUserService;
//
//    @Autowired
//    private RegisterUserRepository registerUserRepository;
//
//    @Autowired
//    public RegisterUserController(RegisterUserService registerUserService) {
//        this.registerUserService = registerUserService;
//    }
//
//    @GetMapping("/findAll")
//    public ResponseEntity<List<RegisterUserDTO>> getAllRegisterUseres() {
//        List<RegisterUserDTO> registerUseres = registerUserService.getAllUsers()
//                .stream()
//                .map(RegisterUser::toDTO)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(registerUseres);
//    }
//
//    @GetMapping
//    public ResponseEntity<ResponseWrapper<RegisterUserDTO>> getRegisterUserById(@RequestParam("id") Long id) {
//        Optional<RegisterUser> optionalUser = registerUserService.getUserById(id);
//        return optionalUser
//                .map(RegisterUser::toDTO)
//                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
//                .orElseGet(() -> ResponseEntity
//                        .status(HttpStatus.NOT_FOUND)
//                        .body(new ResponseWrapper<>("RegisterUser with ID " + id + " not found.")));
//    }
//
//    @PostMapping
//    public RegisterUser createUser(@RequestBody RegisterUser registerUser) {
//        return registerUserService.createUser(registerUser);
//    }
//
//
//    @PutMapping("/update")
//    public ResponseEntity<Object> updateRegisterUser(@RequestParam("id") Long id, @RequestBody RegisterUserDTO registerUserDTO) {
//        if (!id.equals(Long.valueOf(registerUserDTO.getUserId()))) {
//            return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
//        }
//
//        RegisterUser updatedRegisterUser = registerUserService.updateRegisterUserFromDTO(registerUserDTO);
//        return ResponseEntity.ok(updatedRegisterUser.toDTO());
//    }
//
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteUser(@RequestParam("id") Long id) {
//        boolean isDeleted = registerUserService.deleteUser(id);
//
//        if (isDeleted) {
//            return ResponseEntity.ok("Deleted successfully");
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("User with ID " + id + " does not exist");
//        }
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
//        String email = credentials.get("email");
//        String password = credentials.get("password");
//
//        Optional<RegisterUser> verifiedUser = registerUserService.verifyUserCredentials(email, password);
//
//        if (verifiedUser.isPresent()) {
//            return ResponseEntity.ok().body(Map.of("message", "Login successful"));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid email or password"));
//        }
//    }
//
//}