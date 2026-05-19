package com.example.proyectoprogramacion2.model;

public abstract class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private MetodoPago metodoPago;
    private EstadoCompra estadoCompra;

    public Usuario(String ID, String nombre, String correo, String numeroTelefono, MetodoPago metodoPago){
        this.ID=ID;
        this.nombre=nombre;
        this.correo=correo;
        this.numeroTelefono=numeroTelefono;
        this.metodoPago=metodoPago;
    }
}
//   un conjunto de métodos de pago simulados.