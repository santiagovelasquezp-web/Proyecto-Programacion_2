package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.strategy.MetodoPago;

import java.util.List;

public abstract class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String telefono;


    public Usuario(String ID, String nombre, String correo, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}


//   un conjunto de métodos de pago simulados.