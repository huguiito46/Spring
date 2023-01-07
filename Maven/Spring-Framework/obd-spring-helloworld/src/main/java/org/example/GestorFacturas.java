package org.example;

public class GestorFacturas {

    // 1. Atributos
    Calculadora calculadora;
    String nombre;


    //2. Constructores
    public GestorFacturas(Calculadora calculadora, String nombre) {
        System.out.println("Ejecutando constructor de la clase GestorFacturas");
        this.nombre = nombre;
        this.calculadora = calculadora;
    }


}
