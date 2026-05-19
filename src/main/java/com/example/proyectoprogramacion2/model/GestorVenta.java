package com.example.proyectoprogramacion2.model;
//Clase, la cual  gestionara las ventas segun vaya cambiando la asistencia.
public class GestorVenta implements IGestorVenta {
    @Override
    public boolean hayDisponibilidad(Evento evento) {
        return true;
    }

    @Override
    public boolean puedeComprar(Evento evento) {
        return true;
    }

    @Override
    public double calcularDescuento(Evento evento) {
        return 0;
    }

    @Override
    public void registrarCompra(Evento evento, Compra compra) {

    }



}
