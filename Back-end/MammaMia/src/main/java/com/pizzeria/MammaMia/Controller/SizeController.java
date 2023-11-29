package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.SizeDTO;
import com.pizzeria.MammaMia.Entity.Size;
import com.pizzeria.MammaMia.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public List<Size> Findall() {
        return service.Findall();
    }

    @PostMapping
    public ResponseEntity<Size> create(@RequestBody SizeDTO sizeDTO) {
        return service.create(sizeDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<Size> update(@RequestBody SizeDTO sizeDTO, @RequestParam Long id){
        return service.update(id, sizeDTO);
    }

    @DeleteMapping
    public ResponseEntity<Object> Delete(@RequestParam Long id){
        return service.delete(id);
    }
}
