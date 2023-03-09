package com.example.EjercicioSpringRest.controllers;

import com.example.EjercicioSpringRest.entitis.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



/*
webEnvironment para definir un puerto aleatorio
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {


    private TestRestTemplate testRestTemplate;  // Objeto TestRestTemplate sirve para test de integración http, lo que nos permite es usar los métodos http


    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /*
    Spring inyecta el puerto con LocalServerPort
     */

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp(){

        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" +port); // url de nuestra api + el puerto
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    //@DisplayName("Comprobar hola mundo desde controlares Spring REST")
    @Test
    void helloWorld(){

        /*
        responseEntity respuesta http
         */

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/helloWorld",String.class);  // Obtener un resultado de tipo String //
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(200,responseEntity.getStatusCodeValue());
        assertEquals("Hola mundo desde la clase HelloController",responseEntity.getBody());

    }


    @Test
    void findAll() {

        ResponseEntity<Laptop[]> responseEntity = testRestTemplate.getForEntity("/api/laptos",Laptop[].class);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(200,responseEntity.getStatusCodeValue());

        /*
        asList = no los convierte a ArrayList
         */

        List<Laptop> laptops = Arrays.asList(responseEntity.getBody());
        System.out.println(laptops.size());


    }

    @Test
    void findOneById() {

        ResponseEntity<Laptop> responseEntity = testRestTemplate.getForEntity("api/laptops/1",Laptop.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(200, responseEntity.getStatusCodeValue());

    }


    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();

        /*
        Recibimos JSON en las cabeceras
         */

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "marca": "RAZER",
                    "cpu": "AMD",
                    "memoriaRam": 108
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Laptop creado desde Spring Test", result.getMarca());

    }


}