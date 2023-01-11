package com.example.EjercicioSpringRest.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/helloWorld")
    public String holaMundo(){

        return "Hola mundo desde la clase HelloController";

    }
}
