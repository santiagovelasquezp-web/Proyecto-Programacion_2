package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.strategy.MetodoPago;

import java.util.List;

public class Cliente extends Usuario{
    private List<Compra> compras;
    private List<MetodoPago> metodoPagos;
    public Cliente(String ID, String nombre, String correo, String telefono) {
        super(ID, nombre, correo, telefono);
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
}

