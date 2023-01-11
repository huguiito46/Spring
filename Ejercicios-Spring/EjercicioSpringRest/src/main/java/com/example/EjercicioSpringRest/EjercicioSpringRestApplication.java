package com.example.EjercicioSpringRest;

import com.example.EjercicioSpringRest.entitis.Laptop;
import com.example.EjercicioSpringRest.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioSpringRestApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(EjercicioSpringRestApplication.class, args);
        LaptopRepository repository = context.getBean(LaptopRepository.class);

        Laptop pc1 = new Laptop( "ACER", "AMD", 16);
        Laptop pc2 = new Laptop("DEL", "INTEL", 8);
        Laptop pc3 = new Laptop("RAZER", "AMD", 32);

        repository.save(pc1);
        repository.save(pc2);
        repository.save(pc3);

        System.out.println("Ordenadores en la BBDD " +repository.count());
        System.out.println("PC1: " + pc1);
        System.out.println("PC2: " + pc2);
        System.out.println("PC3: " + pc3);


    }

}
