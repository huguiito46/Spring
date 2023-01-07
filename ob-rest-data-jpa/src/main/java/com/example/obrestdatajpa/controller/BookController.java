package com.example.obrestdatajpa.controller;


import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
CRUD sobre la entidad Book
  Request --> Petición
  Controlador -->  Response --> Respuesta
  ResponseEntity --> Devuelves respuestas HTTP devuelves una respuesta en JSON

 http://localhost:8080/api/books

 */


@RestController
public class BookController {

    private final BookRepository bookRepository;  // Variable bookRepository

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Buscar todos los libros(lista de libros)
    @GetMapping("/api/books")
    public List<Book> findAll() {
        // recuperar y devolver los libros de base datos
        return bookRepository.findAll();


    }


    // Buscar un libro en caso de datos según su id
    @GetMapping("api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id); // Permite envolver un id y un nulo

        // Existe el libro ¿Si o No?
        // Opción 1
        // construya una respuesta no found
        if (bookOpt.isPresent()) {

            return ResponseEntity.ok(bookOpt.get());

        } else {

            // construya una respuesta no found
            return ResponseEntity.notFound().build();
        }

    }


    // Opción 3
    //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    // Crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));  // Leer cabeceras
        return bookRepository.save(book);
    }

}
