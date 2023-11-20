//package com.pizzeria.MammaMia.Service;
//
//import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
//import com.pizzeria.MammaMia.Entity.RegisterUser;
//import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.sql.Timestamp;
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//
//@ExtendWith(MockitoExtension.class)
//public class RegisterUserServiceTest {
////
////    @Mock
////    private RegisterUserRepository registerUserRepository;
////
////    @InjectMocks
////    private RegisterUserService registerUserService;
////
////    @BeforeEach
////    public void setup() {
////        MockitoAnnotations.openMocks(this);
////    }
////
////    @Test
////    public void testGetAllUsers() {
////        RegisterUser user = new RegisterUser(1L, "John", "john@email.com", "pass", "salt", true, new Timestamp(System.currentTimeMillis()));
////        when(registerUserRepository.findAll()).thenReturn(Arrays.asList(user));
////
////        assertEquals(1, registerUserService.getAllUsers().size());
////    }
////
////    @Test
////    public void testGetUserByIdFound() {
////        RegisterUser user = new RegisterUser(1L, "John", "john@email.com", "pass", "salt", true, new Timestamp(System.currentTimeMillis()));
////        when(registerUserRepository.findById(1L)).thenReturn(Optional.of(user));
////
////        Optional<RegisterUser> foundUser = registerUserService.getUserById(1L);
////
////        assertTrue(foundUser.isPresent());
////        assertEquals("John", foundUser.get().getName());
////    }
////
////    @Test
////    public void testGetUserByIdNotFound() {
////        when(registerUserRepository.findById(1L)).thenReturn(Optional.empty());
////
////        Optional<RegisterUser> foundUser = registerUserService.getUserById(1L);
////
////        assertFalse(foundUser.isPresent());
////    }
////
////    @Test
////    public void testUpdateUserFromDtoUserExists() {
////        RegisterUserDTO userDTO = new RegisterUserDTO(1L, "Jane", "jane@email.com", "newpass", "newsalt", true, new Timestamp(System.currentTimeMillis()));
////        RegisterUser existingUser = new RegisterUser(1L, "John", "john@email.com", "pass", "salt", true, new Timestamp(System.currentTimeMillis()));
////
////        when(registerUserRepository.findById(1L)).thenReturn(Optional.of(existingUser));
////        when(registerUserRepository.save(any(RegisterUser.class))).thenReturn(existingUser);
////
////        RegisterUser updatedUser = registerUserService.updateRegisterUserFromDTO(userDTO);
////
////        assertEquals("Jane", updatedUser.getName());
////    }
////
////    @Test
////    public void testUpdateUserFromDtoUserDoesNotExist() {
////        RegisterUserDTO userDTO = new RegisterUserDTO(1L, "Jane", "jane@email.com", "newpass", "newsalt", true, new Timestamp(System.currentTimeMillis()));
////
////        when(registerUserRepository.findById(1L)).thenReturn(Optional.empty());
////
////        assertThrows(EntityNotFoundException.class, () -> {
////            registerUserService.updateRegisterUserFromDTO(userDTO);
////        });
////    }
//
//}
