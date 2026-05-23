package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.enums.EstadoCompra;

import java.util.List;

public abstract class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String telefono;

    private List<Compra> compras;

    public Usuario(String ID, String nombre, String correo, String telefono){
        this.ID=ID;
        this.nombre=nombre;
        this.correo=correo;
        this.telefono = telefono;
    }
}
//   un conjunto de métodos de pago simulados.