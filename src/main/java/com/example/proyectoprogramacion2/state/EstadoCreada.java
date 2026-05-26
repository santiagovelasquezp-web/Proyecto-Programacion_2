 package com.example.proyectoprogramacion2.state;

 import com.example.proyectoprogramacion2.enums.EstadoCompra;
 import com.example.proyectoprogramacion2.model.Compra;
 import com.example.proyectoprogramacion2.state.EstadoCompraState;

 public class EstadoCreada implements EstadoCompraState {
        @Override
        public void procesar(Compra compra) {
            // Cuando se procesa una compra creada, pasa a estar PAGADA
            compra.setEstado(EstadoCompra.CONFIRMADA); // O PAGADA, según tu Enum
            System.out.println("Transacción exitosa: La compra ha sido pagada.");
        }

        @Override
        public void cancelar(Compra compra) {
            compra.setEstado(EstadoCompra.CANCELADA);
            System.out.println("La compra ha sido cancelada.");
        }
    }

