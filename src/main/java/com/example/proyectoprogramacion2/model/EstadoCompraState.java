package com.example.proyectoprogramacion2.model;

public interface EstadoCompraState {
    void procesar(Compra compra);
    void cancelar(Compra compra);
//interface de state para cambiar el comportamiento segun el el estado de la compra realizada
}
