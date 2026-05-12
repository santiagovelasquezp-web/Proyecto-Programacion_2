package com.example.proyectoprogramacion2.model;

public abstract class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String numeroTelefono;

    public Usuario(String ID, String nombre, String correo, String numeroTelefono){
        this.ID=ID;
        this.nombre=nombre;
        this.correo=correo;
        this.numeroTelefono=numeroTelefono;
    }
}
//   un conjunto de métodos de pago simulados.