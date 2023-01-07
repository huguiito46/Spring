package com.example;


import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    // 1. Atributos
    Calculadora calculadora;


    //2. Constructores

    public GestorFacturas(Calculadora calculadora) {
        System.out.println("Ejecutando constructor de la clase GestorFacturas");
        this.calculadora = calculadora;
    }

}
