package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.composite.Asiento;
import com.example.proyectoprogramacion2.composite.Zona;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoCompra;

public class Entrada {
    private Evento evento;
    private ServicioAdicional servicio;
    private String idEntrada;
    private Zona zona;
    private Asiento asiento;
    private double precioFinal;
    private EstadoCompra estadoCompra;

    public Entrada(String idEntrada,Evento evento, Zona zona, Asiento asiento, double precioFinal, EstadoCompra estadoCompra){
        this.idEntrada=idEntrada;
        this.evento=evento;
        this.zona=zona;
        this.asiento=asiento;
        this.precioFinal=precioFinal;
        this.estadoCompra=estadoCompra;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ServicioAdicional getServicio() {
        return servicio;
    }

    public void setServicio(ServicioAdicional servicio) {
        this.servicio = servicio;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public EstadoCompra getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(EstadoCompra estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "evento=" + evento +
                ", servicio=" + servicio +
                ", idEntrada='" + idEntrada + '\'' +
                ", zona=" + zona +
                ", asiento=" + asiento +
                ", precioFinal=" + precioFinal +
                ", estadoCompra=" + estadoCompra +
                '}';
    }
}
