package com.example.obspringdatajpa;

/*
@Entity significa que va a ser una entidad esto quiere decir que esta clase va a estar en base de datos.
@Id anotación que significa que el Long id es un ID.
@GeneratedValue especificamos como se va a crear el id.
(strategy = GenerationType.IDENTITY) --> Se va a generar solo los ID auto incremental

JPA es una especificación de base de datos.
*/


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

    // Atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fabricante;
    private String modelo;
    private Integer anio;

    // Constructores

    public Coche(){

    }


    public Coche(Long id, String fabricante, String modelo, Integer anio) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anio = anio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    // tostring
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", manufacturer='" + fabricante + '\'' +
                ", model='" + modelo + '\'' +
                ", year=" + anio +
                '}';
    }
}