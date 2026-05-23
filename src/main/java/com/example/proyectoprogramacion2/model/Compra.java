package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoCompra;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private String idCompra;

    private Usuario usuario;
    private Evento evento;

    private LocalDateTime fechaCreacion;

    private EstadoCompra estado;

    private List<Entrada> entradas;

    private List<ServicioAdicional> servicios;

    private Pago pago;
    //metodo para calcular el valor de la entrada
    // crear metodos para el cambio en compras y demas
    public double calcularTotal(){

    }
}
