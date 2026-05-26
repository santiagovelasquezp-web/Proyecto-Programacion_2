package com.example.proyectoprogramacion2.strategy;

public class PagoTarjeta implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("La compra ha sido confirmada con tarjeta");
    }
}
