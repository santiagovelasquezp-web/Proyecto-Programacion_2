package com.example.proyectoprogramacion2.decorator;

public class SeguroDecorator implements ServicioAdicional {
    @Override
    public double agregarCosto() {

        return 20000;
    }

    @Override
    public String descripcion() {

        return "Seguro para evento";
    }

    @Override
    public String toString() {

        return descripcion() + " - $" + agregarCosto();
    }
    //clase que decoraa la entrada con un servicio de seguro
}
