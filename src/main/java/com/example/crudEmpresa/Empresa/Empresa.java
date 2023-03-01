package com.example.crudEmpresa.Empresa;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nombre;
    private int numNIT;
    private LocalDate fechaFundacion;
    private String direccion;

    public Empresa() {
    }

    public Empresa(int id, String nombre, int numNIT, LocalDate fechaFundacion, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.numNIT = numNIT;
        this.fechaFundacion = fechaFundacion;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumNIT() {
        return numNIT;
    }

    public void setNumNIT(int numNIT) {
        this.numNIT = numNIT;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
