package com.example.Ejercicio3springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio3SpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Ejercicio3SpringBootApplication.class, args);

        PersonaRepository repository = context.getBean(PersonaRepository.class);

        System.out.println(repository.count());

        /*
        Persona persona1 = new Persona("Carlos","Gomez","92922");
        Persona persona2 = new Persona("Eva","Gomez","92121222");
        Persona persona3 = new Persona("Maria","Torres","92122");
        Persona persona4 = new Persona("Carla","Gomez","9212122");
/*
        /*
        repository.save(persona1);
        repository.save(persona2);
        repository.save(persona3);
        repository.save(persona4);
*/
        System.out.println("Objetos persona en la bbdd: " +repository.count());

        if(repository.existsById(2L)){
            System.out.println("El id existe");

        }else{
            System.out.println("El id no existe");
        }
    }

}
