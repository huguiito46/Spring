package com.ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class NotificacionService {

    public NotificacionService(){
        System.out.println("Ejecutando constructor NotificacionService");

    }

    public String imprimirSaludo() {

        return "Hola  desde la clase NotificacionService";

    }


}
