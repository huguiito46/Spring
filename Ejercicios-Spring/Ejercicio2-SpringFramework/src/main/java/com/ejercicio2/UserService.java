package com.ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {

   NotificacionService notificacionService;

    public UserService() {

    }

    public UserService(NotificacionService notificacionService){
        System.out.println("Ejecutando constructor de la clase UserService");
        this.notificacionService = notificacionService;

    }


}
