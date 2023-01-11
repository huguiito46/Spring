package com.example.EjercicioSpringRest.entitis;


import jakarta.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String cpu;
    private Integer memoriaRam;

    public Laptop() {}

    public Laptop(String marca, String cpu, Integer memoriaRam) {
        this.marca = marca;
        this.cpu = cpu;
        this.memoriaRam = memoriaRam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memoriaRam=" + memoriaRam +
                '}';
    }
}
