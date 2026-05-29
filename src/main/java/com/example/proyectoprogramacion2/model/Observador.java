package com.example.proyectoprogramacion2.model;

public interface Observador {
    void actualizar(String mensaje);
    //interface observadora para que las clases que implementan puedan ser notificadas en un cambio de ajustes
}
