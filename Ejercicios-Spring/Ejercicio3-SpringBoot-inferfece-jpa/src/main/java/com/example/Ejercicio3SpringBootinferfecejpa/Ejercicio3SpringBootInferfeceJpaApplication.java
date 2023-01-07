package com.example.Ejercicio3SpringBootinferfecejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class Ejercicio3SpringBootInferfeceJpaApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(Ejercicio3SpringBootInferfeceJpaApplication.class, args);
		EstudianteRepository repository = context.getBean(EstudianteRepository.class);

		Estudiante estudiante1 = new Estudiante("Maria Fernanda", "Gonzalez", 40);
		Estudiante estudiante2 = new Estudiante("Luna", "Gonzalez", 46);
		Estudiante estudiante3 = new Estudiante("Carlos", "Paredes", 43);

		repository.save(estudiante1);
		repository.save(estudiante2);
		repository.save(estudiante3);

		System.out.println("Estudiantes en la bbdd " +repository.count());

	}
}
