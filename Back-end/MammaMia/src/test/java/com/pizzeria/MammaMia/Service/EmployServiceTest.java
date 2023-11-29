package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import com.pizzeria.MammaMia.Repository.EmployRepository;
import com.pizzeria.MammaMia.Repository.RegisterUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployServiceTest {

    @InjectMocks
    private EmployService employService;

    @Mock
    private EmployRepository employRepository;

    @Mock
    private RegisterUserRepository registerUserRepository;

    @BeforeEach
    public void setup() throws Exception {
        try (AutoCloseable closeable = MockitoAnnotations.openMocks(this)) {
        }
    }
//
//            @Test
//    public void testGetEmployById() {
//        Employ employ = new Employ();
//        employ.setId(1L);
//        when(employRepository.findById(1L)).thenReturn(Optional.of(employ));
//
//        Optional<Employ> result = employService.getEmployById(1L);
//        assertTrue(result.isPresent());
//        assertEquals(1L, result.get().getId());
//    }
//
//    @Test
//    public void testCreateEmployFromDTO() {
//        EmployDTO employDto = new EmployDTO();
//        employDto.setId(1L);
//        employDto.setName("John");
//
//        RegisterUser registerUser = new RegisterUser();
//        registerUser.setUserId(1L);
//
//        employDto.setRegisterUser(registerUser);
//        when(registerUserRepository.findById(1L)).thenReturn(Optional.of(registerUser));
//        when(employRepository.save(any(Employ.class))).thenAnswer(i -> i.getArguments()[0]);
//
//        Employ result = employService.createEmployFromDTO(employDto);
//        assertEquals("John", result.getName());
//    }

//
//    @Test
//    public void testUpdateEmployFromDTO() {
//        Employ employ = new Employ();
//        employ.setId(1L);
//        employ.setName("John");
//
//        EmployDTO employDto = new EmployDTO();
//        employDto.setId(1L);
//        employDto.setName("Jane");
//
//        when(employRepository.findById(1L)).thenReturn(Optional.of(employ));
//        when(employRepository.save(any(Employ.class))).thenAnswer(i -> i.getArguments()[0]);
//
//        Employ updated = employService.updateEmployFromDTO(employDto);
//        assertEquals("Jane", updated.getName());
//    }

    @Test
    public void testDeleteEmploy() {
        when(registerUserRepository.existsById(1L)).thenReturn(true);

        boolean result = employService.deleteEmploy(1L);
        assertTrue(result);
        verify(registerUserRepository, times(1)).deleteById(1L);
    }
}
