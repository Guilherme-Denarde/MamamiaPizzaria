package com.pizzeria.MammaMia.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Service.EmployService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployController.class)
public class EmployControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployService employService;

    @BeforeEach
    void setUp() {
        List<Employ> mockEmployList = new ArrayList<>();
        when(employService.getAllEmployes()).thenReturn(mockEmployList);

        Long testId = 1L;
        Employ mockEmploy = new Employ();
        when(employService.getEmployById(testId)).thenReturn(Optional.of(mockEmploy));

    }

//    @Test
//    void createEmployTest() throws Exception {
//        EmployDTO employDto = new EmployDTO();
//        employDto.setId(1L);
//        employDto.setName("John");
//
//        RegisterUser registerUser = new RegisterUser();
//        registerUser.setUserId(1L);
//        employDto.setRegisterUser(registerUser);
//
//        String employDtoJson = objectMapper.writeValueAsString(employDto);
//
//        mockMvc.perform(post("/api/employ")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(employDtoJson))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    void getAllEmployesTest() throws Exception {
        mockMvc.perform(get("/api/employ/findAll"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getEmployByIdTest() throws Exception {
        Long testId = 1L;
        mockMvc.perform(get("/api/employ?id=" + testId))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteEmployTest() throws Exception {
        Long testIdToDelete = 1L;

        when(employService.deleteEmploy(testIdToDelete)).thenReturn(true);

        mockMvc.perform(delete("/api/employ/delete?id=" + testIdToDelete))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        when(employService.deleteEmploy(testIdToDelete)).thenReturn(false);

        mockMvc.perform(delete("/api/employ/delete?id=" + testIdToDelete))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateEmployTest() throws Exception {
        EmployDTO employDtoToUpdate = new EmployDTO();
        employDtoToUpdate.setId(1L);
        employDtoToUpdate.setName("John Updated");

        Employ mockUpdatedEmploy = new Employ();
        when(employService.updateEmployFromDTO(any(EmployDTO.class))).thenReturn(mockUpdatedEmploy);

        String employDtoJson = objectMapper.writeValueAsString(employDtoToUpdate);

        mockMvc.perform(put("/api/employ/update?id=" + employDtoToUpdate.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employDtoJson))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
