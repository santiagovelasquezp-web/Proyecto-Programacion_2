package com.example.proyectoprogramacion2.decorator;

public class VIPDecorator implements ServicioAdicional {
    @Override
    public double agregarCosto() {

        return 50000;
    }

    @Override
    public String descripcion() {

        return "Experiencia VIP";
    }

    @Override
    public String toString() {

        return descripcion() + " - $" + agregarCosto();
    }
}
