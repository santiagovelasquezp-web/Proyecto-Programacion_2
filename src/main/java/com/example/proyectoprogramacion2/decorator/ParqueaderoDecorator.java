package com.example.proyectoprogramacion2.decorator;

public class ParqueaderoDecorator implements ServicioAdicional{
    @Override
    public double agregarCosto() {

        return 30000;
    }

    @Override
    public String descripcion() {

        return "Servicio de parqueadero agregado";
    }

    @Override
    public String toString() {

        return descripcion() + " - $" + agregarCosto();
    }
}
