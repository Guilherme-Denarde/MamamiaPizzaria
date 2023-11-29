package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.SizeDTO;
import com.pizzeria.MammaMia.Entity.Size;
import com.pizzeria.MammaMia.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/size")
public class SizeController {
    //aaaa
    @Autowired
    private SizeService service;

    @GetMapping("/findall")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")


    public List<Size> Findall() {
        return service.Findall();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole( 'MANAGER')")

    public ResponseEntity<Size> create(@RequestBody SizeDTO sizeDTO) {
        return service.create(sizeDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('MANAGER')")

    public ResponseEntity<Size> update(@RequestBody SizeDTO sizeDTO, @RequestParam Long id){
        return service.update(id, sizeDTO);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('MANAGER')")

    public ResponseEntity<Object> Delete(@RequestParam Long id){
        return service.delete(id);
    }
}
