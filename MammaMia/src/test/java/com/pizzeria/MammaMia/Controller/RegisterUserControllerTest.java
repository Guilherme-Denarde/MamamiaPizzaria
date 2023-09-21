package com.pizzeria.MammaMia.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Service.RegisterUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.extension.ExtendWith;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class RegisterUserControllerTest {

    @Mock
    private RegisterUserService registerUserService;

    @InjectMocks
    private RegisterUserController registerUserController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registerUserController).build();
    }
//
//    @Test
//    public void testGetAllRegisterUsers() throws Exception {
//        RegisterUser user = new RegisterUser(1L, "John", "john@email.com", "pass", "salt", true, new Timestamp(System.currentTimeMillis()));
//        when(registerUserService.getAllUsers()).thenReturn(Arrays.asList(user));
//
//        mockMvc.perform(get("/api/users/findAll"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name").value("John"));
//    }
//
//    @Test
//    public void testGetRegisterUserById() throws Exception {
//        RegisterUser user = new RegisterUser(1L, "John", "john@email.com", "pass", "salt", true, new Timestamp(System.currentTimeMillis()));
//        when(registerUserService.getUserById(1L)).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/api/users?id=1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name").value("John"));
//    }

}
