package com.example.proyectoprogramacion2.model;

import java.time.LocalDateTime;

public class Incidencia {

    private String idIncidencia;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha;
    private String Entidad;

    public Incidencia (String idIncidencia, String tipo, String descripcion, LocalDateTime fecha, String Entidad ){
        this.idIncidencia = idIncidencia;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.Entidad = Entidad;
    }
    public String getidIncidencia(){
        return idIncidencia;
    }
    public void setidIncidencia(String idIncidencia){
        this.idIncidencia = idIncidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String entidad) {
        Entidad = entidad;
    }
}
