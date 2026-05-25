package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.strategy.MetodoPago;

import java.util.List;

public class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String telefono;

    private List<Compra> compras;
    private List<MetodoPago> metodoPagos;

    public Usuario(String ID, String nombre, String correo, String telefono){
        this.ID=ID;
        this.nombre=nombre;
        this.correo=correo;
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

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<MetodoPago> getMetodoPagos() {
        return metodoPagos;
    }

    public void setMetodoPagos(List<MetodoPago> metodoPagos) {
        this.metodoPagos = metodoPagos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", compras=" + compras +
                ", metodoPagos=" + metodoPagos +
                '}';
    }
}
//   un conjunto de métodos de pago simulados.