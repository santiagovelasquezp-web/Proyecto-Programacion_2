package com.example.proyectoprogramacion2.decorator;

public class BebidaDecorator implements ServicioAdicional {
    @Override
    public double agregarCosto() {

        return 15000;
    }

    @Override
    public String descripcion() {

        return "Combo de bebida";
    }

    @Override
    public String toString() {

        return descripcion() + " - $" + agregarCosto();
    }
    //clase decoradora, con servicio adicional de bebida, implementa el metodo para agregar el objeto a la clase entrada sin modificar la clase y solo agregando costo
}
