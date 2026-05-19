package com.example.proyectoprogramacion2.model;

public class GestorVentaVIP implements IGestorVenta{


    @Override
    public boolean hayDisponibilidad(Evento evento) {
        return false;
    }

    @Override
    public boolean puedeComprar(Evento evento) {
        return false;
    }

    @Override
    public double calcularDescuento(Evento evento) {
        return 0.15;
    }

    @Override
    public void registrarCompra(Evento evento, Compra compra) {

    }
}
