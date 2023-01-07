package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

/*

REST --> Un servicio REST un punto de comunicación pero desde el exterior a través de peticiones HTTP con un puerto.

 */


@SpringBootApplication
public class ObRestDataJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ObRestDataJpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        // CRUD //
        // Crear un libro //
        Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
        Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 10, 11), true);

        System.out.println("Antes de guardar número de libros en base de datos: " + repository.findAll().size());

        // Almacenar un libro
        repository.save(book1);
        repository.save(book2);

        // Recuperar todos los libros
        System.out.println("Después de guardar todos los libros: " + repository.findAll().size());


        // Borrar un libro el ID 1
        //repository.deleteById(1L);

        System.out.println("Borrando por ID " + repository.findAll().size());


    }

}
