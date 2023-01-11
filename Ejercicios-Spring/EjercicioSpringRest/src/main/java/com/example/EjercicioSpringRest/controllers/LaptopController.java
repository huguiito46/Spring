package com.example.EjercicioSpringRest.controllers;


import com.example.EjercicioSpringRest.entitis.Laptop;
import com.example.EjercicioSpringRest.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    private final LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @GetMapping("/api/laptos")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();


    }

    @PostMapping("/api/laptos")
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }


}
