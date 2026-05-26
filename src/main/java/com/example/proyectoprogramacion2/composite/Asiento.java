package com.example.proyectoprogramacion2.composite;

import com.example.proyectoprogramacion2.enums.EstadoAsiento;

public class Asiento implements ComponenteRecinto{
    private String idAsiento;
    private String fila;
    private int numero;
    private EstadoAsiento estado;

    public Asiento(String idAsiento, String fila, int numero, EstadoAsiento estado) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }
    @Override
    public int getDisponibilidad() {
        return (this.estado == EstadoAsiento.DISPONIBLE) ? 1 : 0;
    }
//implementa la interface para que zona pueda conocer su disponibilidad
    @Override
    public String getDetalles() {
        return "Asiento " + fila + numero;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "idAsiento='" + idAsiento + '\'' +
                ", fila='" + fila + '\'' +
                ", numero=" + numero +
                ", estado=" + estado +
                '}';
    }


}


