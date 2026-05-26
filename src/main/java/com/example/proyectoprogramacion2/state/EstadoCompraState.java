package com.example.proyectoprogramacion2.state;

import com.example.proyectoprogramacion2.model.Compra;

public interface EstadoCompraState {
    void procesar(Compra compra);
    void cancelar(Compra compra);

}
