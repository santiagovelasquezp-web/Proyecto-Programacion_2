package com.example.proyectoprogramacion2.model;

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

    public Entrada(String idEntrada, Zona zona, Asiento asiento, double precioFinal, EstadoCompra estadoCompra){
        this.idEntrada=idEntrada;
        this.zona=zona;
        this.asiento=asiento;
        this.precioFinal=precioFinal;
        this.estadoCompra=estadoCompra;
    }

}
