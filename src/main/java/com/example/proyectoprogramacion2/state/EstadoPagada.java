package com.example.proyectoprogramacion2.state;

import com.example.proyectoprogramacion2.model.Compra;
import com.example.proyectoprogramacion2.state.EstadoCompraState;

public class EstadoPagada implements EstadoCompraState {
    @Override
    public void procesar(Compra compra) {
        System.out.println("Aviso: Esta compra ya fue procesada anteriormente.");
    }

    @Override
    public void cancelar(Compra compra) {
        System.out.println("Error: No se puede cancelar una compra que ya ha sido pagada.");
    }

}
