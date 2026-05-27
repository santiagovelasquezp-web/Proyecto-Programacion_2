package com.example.proyectoprogramacion2.strategy;

public class PagoEfectivo implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
System.out.print("compra hecha con efectivo");
    }

    @Override
    public String toString() {
        return "PagoEfectivo{}";
    }
}
//implementacione spara generar el pago segun la elección del cliente
