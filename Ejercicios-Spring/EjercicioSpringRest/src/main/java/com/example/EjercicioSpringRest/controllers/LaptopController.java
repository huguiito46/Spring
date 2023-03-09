package com.example.EjercicioSpringRest.controllers;


import com.example.EjercicioSpringRest.entitis.Laptop;
import com.example.EjercicioSpringRest.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @GetMapping("/api/laptos")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();

    }

    @GetMapping("/api/laptos/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){

        Optional<Laptop> laptop = laptopRepository.findById(id);
        // Opción 1
        if(laptop.isPresent())
            return ResponseEntity.ok(laptop.get());
        else
            return ResponseEntity.notFound().build();

        // Opción 2
        // return bookOpt.orElse(null);

        // Opción 3
        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }



    @PostMapping("/api/laptos")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {

        if(laptop.getId() != null){  // Si el id existe, por lo tanto no es una creación
            log.warn("Intentado crear un libro con id");
            return ResponseEntity.badRequest().build();
        }
        Laptop save = laptopRepository.save(laptop);
        return ResponseEntity.ok(save);

    }


    @PutMapping("/api/laptos")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

       if(laptop.getId() == null){
           log.warn("Intentado crear un libro con id");
           return ResponseEntity.badRequest().build();
       }

       if(!laptopRepository.existsById(laptop.getId())){
           log.warn("Intentando crear un libro con id");
           return ResponseEntity.notFound().build();
       }

       Laptop result = laptopRepository.save(laptop);
       return ResponseEntity.ok(result);

    }

    @DeleteMapping("/api/laptos/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/api/laptos")
    public ResponseEntity<Laptop> deleteAll(){

        log.info("Rest para eliminar todos los libros");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }
}
