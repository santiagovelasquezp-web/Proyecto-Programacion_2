package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.strategy.MetodoPago;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private String idCompra;
    private Usuario usuario;
    private Evento evento;
    private LocalDateTime fechaCreacion;
    private EstadoCompra estado;
    private double total;
    private MetodoPago metodoPago;
    private List<Entrada> entradas;
    private List<ServicioAdicional> servicios;
    private MetodoPago pago;

    public Compra(String idCompra, Usuario usuario, Evento evento, LocalDateTime fechaCreacion, EstadoCompra estado, double total, MetodoPago metodoPago, List<Entrada> entradas, List<ServicioAdicional> servicios, MetodoPago pago) {
        this.idCompra = idCompra;
        this.usuario = usuario;
        this.evento = evento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.total = total;
        this.metodoPago = metodoPago;
        this.entradas = entradas;
        this.servicios = servicios;
        this.pago = pago;
    }

    //metodo para calcular el valor de la entrada
    // crear metodos para el cambio en compras y demas



}
