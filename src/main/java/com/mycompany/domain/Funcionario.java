/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domain;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Francisco
 */
public class Funcionario {

    private int funcionarioId;
    private TipoDocumento tipoDocumento;
    private String numeroIdentificacion;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private EstadoCivil estadoCivil;
    private Sexo sexo;
    private String direccion;
    private String celular;
    private int estado;
    private LocalDateTime fechaCreacion;

    public int getfuncionarioId() {
        return funcionarioId;
    }

    public void setfuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Funcionario() {
    }

    public Funcionario(int funcionarioId, TipoDocumento tipoDocumento, String numeroIdentificacion, String nombre1, String nombre2, String apellido1, String apellido2, Date fechaNacimiento, EstadoCivil estadoCivil, Sexo sexo, String direccion, String celular, int estado, LocalDateTime fechaCreacion) {
        this.funcionarioId = funcionarioId;
        this.tipoDocumento = tipoDocumento;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.direccion = direccion;
        this.celular = celular;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return nombre1 + " " + nombre2 + " " + apellido1 + " " + apellido2;
    }

    /*
        public String toString() {
        return "Tipo Documento: " + tipoDocumento.getTipoDocumento()
                + "\nNumero: " + numeroIdentificacion + "\nNombres: " + nombre1 + " " + nombre2 
                + "\nApellidos: " + apellido1 + " " + apellido2
                + "\nFecha Nacimiento: " + fechaNacimiento + "\nEstado Civil: " + estadoCivil.getEstadoCivil()
                + "\nSexo: " + sexo.getSexo() + "\nDireccion: " + direccion + "\nCelular: " + celular
                + "\nFecha Creacion: " + fechaCreacion;}
     */
}
