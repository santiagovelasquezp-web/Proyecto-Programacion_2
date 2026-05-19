package com.example.proyectoprogramacion2.model;

public interface IGestorVenta {
    boolean hayDisponibilidad(Evento evento);
    boolean puedeComprar(Evento evento);

    double calcularDescuento(Evento evento);

    void registrarCompra(Evento evento, Compra compra);

}
