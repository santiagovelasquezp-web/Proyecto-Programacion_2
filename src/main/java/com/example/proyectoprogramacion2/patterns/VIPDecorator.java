package com.example.proyectoprogramacion2.patterns;

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
    //clase decoradora que agrega la opción de experiencia VIP al objeto entrada
}
