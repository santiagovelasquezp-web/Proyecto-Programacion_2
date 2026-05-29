package com.example.proyectoprogramacion2.patterns;

public interface ComponenteRecinto {
    int getDisponibilidad();
    String getDetalles();

    //interface para que las clases jerarquizadas implemeten de ella
    //y puedan actuar como un objeto igual a las otras clases Recinto-Zonas-Asientos
}