/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domain;

import java.time.LocalDate;

/**
 *
 * @author Francisco
 */
public class EstadoCivil {

    private int id;
    private String estadoCivil;
    private int estado;
    private LocalDate fechaCreacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoCivil(int id, String estadoCivil, int estado, LocalDate fechaCreacion) {
        this.id = id;
        this.estadoCivil = estadoCivil;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoCivil() {
    }

    @Override
    public String toString() {
        return estadoCivil;
    }

}
