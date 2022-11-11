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
public class Sexo {

    private int sexoId;
    private String sexo;
    private String sigla;
    private int estado;
    private LocalDate fechaCreacion;

    public int getSexoId() {
        return sexoId;
    }

    public void setSexoId(int sexoId) {
        this.sexoId = sexoId;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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

    public Sexo() {
    }

    public Sexo(int sexoId, String sexo, String sigla, int estado, LocalDate fechaCreacion) {
        this.sexoId = sexoId;
        this.sexo = sexo;
        this.sigla = sigla;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return sexo;
    }
    
    
}
