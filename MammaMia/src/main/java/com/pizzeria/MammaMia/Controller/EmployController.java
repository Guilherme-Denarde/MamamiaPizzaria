package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employ")
public class EmployController {

    @Autowired
    private EmployService employService;

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployDTO>> getAllEmployes() {
        List<EmployDTO> employes = employService.getAllEmployes()
                .stream()
                .map(Employ::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employes);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<EmployDTO>> getEmployById(@RequestParam("id") Long id) {
        return employService.getEmployById(id)
                .map(Employ::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Employ with ID " + id + " not found.")));
    }

    @PostMapping
    public ResponseEntity<EmployDTO> createEmploy(@RequestBody EmployDTO employDto) {
        Employ employ = employService.createEmployFromDTO(employDto);
        System.out.println(employ.getRegisterUser().getName());
        EmployDTO employDTO = employ.toDTO();
        System.out.println(employDTO.getRegisterUser().getName());
        return ResponseEntity.ok(employDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployDTO> updateEmploy(@RequestParam("id") Long id, @RequestBody EmployDTO employDto) {
        if (!id.equals(employDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Employ updatedEmploy = employService.updateEmployFromDTO(employDto);
        return ResponseEntity.ok(updatedEmploy.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmploy(@RequestParam("id") Long id) {
        employService.deleteEmploy(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
