package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.SaborDTO;
import com.pizzeria.MammaMia.Entity.Sabor;
import com.pizzeria.MammaMia.Repository.SaborRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaborService {

    @Autowired
    private SaborRepository repository;


    public List<Sabor> Findall() { return repository.findAll();}

    public Sabor findByNome(String name) { return repository.findByNome(name);}

    public ResponseEntity<Object> update (Long id, SaborDTO saborDTO){
        Optional<Sabor> sabor_update = repository.findById(id);
        if ( sabor_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Sabor sabor = sabor_update.get();
            BeanUtils.copyProperties(saborDTO,sabor);
            repository.save(sabor);
            return ResponseEntity.ok(sabor_update);

        }

    }

    public ResponseEntity<Sabor> create(SaborDTO saborDTO){

        try {
            Sabor sabor = new Sabor();
            BeanUtils.copyProperties(saborDTO, sabor);

            repository.save(sabor);

            return ResponseEntity.ok(sabor);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Sabor> sabor_optional = repository.findById(id) ;
        if ( sabor_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Sabor sabor = sabor_optional.get();
            repository.delete(sabor);
            return ResponseEntity.ok("Sabore deletado com sucesso");


        }

    }





}
