package com.mycompany.domain;

import java.time.LocalDate;

/**
 * @author Francisco
 */
public class TipoDocumento {

    private int id;
    private String tipoDocumento;
    private String sigla;
    private int estado;
    private LocalDate fechaCreacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public TipoDocumento() {
    }

    public TipoDocumento(int id, String tipoDocumento, String sigla, int estado, LocalDate fechaCreacion) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.sigla = sigla;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    
    @Override
    public String toString() {
        return tipoDocumento;
    }

}
