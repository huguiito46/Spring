package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*

1) Tener el contexto que es esto
ApplicationContext context

 */

@SpringBootApplication
public class ObSpringdatajpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);

        CocheRepository repository = context.getBean(CocheRepository.class);

        System.out.println("El número de coches en base de datos es: " + repository.count());   // Dame un bean de la clase coche


    }

}


