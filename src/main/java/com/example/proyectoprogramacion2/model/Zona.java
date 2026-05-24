package com.example.proyectoprogramacion2.model;

import java.util.List;

public class Zona {
    private String idZona;
    private String nombre;
    private int capacidad;
    private double precioBase;

    private List<Asiento> asientos;

    public Zona(String idZona, String nombre, int capacidad, double precioBase, List<Asiento> asientos) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.asientos = asientos;
    }
}
// (p. ej., VIP, Preferencial, General). Incluye identificador único (idZona),
// nombre, capacidad, precio base y configuración de asientos (si aplica).