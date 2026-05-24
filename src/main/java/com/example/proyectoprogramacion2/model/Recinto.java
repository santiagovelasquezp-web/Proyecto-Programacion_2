package com.example.proyectoprogramacion2.model;

import java.util.List;

public class Recinto {
    private String idRecinto;
    private String nombre;
    private String direccion;
    private String ciudad;

    private List<Zona> zonas;

    public Recinto(String idRecinto, String nombre, String direccion, String ciudad, List<Zona> zonas) {
        this.idRecinto = idRecinto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.zonas = zonas;
    }


    }

