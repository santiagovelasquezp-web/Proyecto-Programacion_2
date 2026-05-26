package com.example.proyectoprogramacion2.service;

import com.example.proyectoprogramacion2.composite.Asiento;
import com.example.proyectoprogramacion2.composite.Zona;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.singleton.SistemaConcierto;
import com.example.proyectoprogramacion2.state.EstadoCompraState;
import com.example.proyectoprogramacion2.state.EstadoCreada;
import com.example.proyectoprogramacion2.strategy.MetodoPago;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraService {

    // Método principal para realizar la compra
    public Compra realizarCompra(Usuario usuario, Evento evento, Zona zona, Asiento asiento,
                                 MetodoPago metodoPago, List<ServicioAdicional> servicios) {

        // 1. Validación de disponibilidad
        if (asiento.getEstado() == EstadoAsiento.OCUPADO) {
            System.out.println("El asiento no está disponible.");
            return null;
        }

        // 2. Cálculo de Precios (RF-004)
        // Nota: Asegúrate de que tu clase Zona tenga un método getPrecio()
        double precioEntrada = zona.getPrecio();
        double totalCompra = precioEntrada;

        // 3. Aplicación de Decorator (Servicios Adicionales)
        for (ServicioAdicional servicio : servicios) {
            totalCompra += servicio.agregarCosto(); // Usando tu método del Decorator
        }

        // 4. Marcar asiento como ocupado
        asiento.setEstado(EstadoAsiento.OCUPADO);

        // 5. Crear la lista de entradas para esta compra
        List<Entrada> entradas = new ArrayList<>();
        Entrada nuevaEntrada = new Entrada(
                "ENT-" + System.currentTimeMillis(),
                evento, zona, asiento, precioEntrada, EstadoCompra.CREADA
        );
        entradas.add(nuevaEntrada);


        Compra compra = new Compra(
                "COM-" + System.currentTimeMillis(),
                usuario,
                evento,
                LocalDateTime.now(),
                EstadoCompra.CREADA,
                totalCompra,
                metodoPago,
                entradas,
                servicios
        );

        EstadoCompraState estadoActual = new EstadoCreada();
        estadoActual.procesar(compra);

        // 8. REGISTRO EN EL SINGLETON (Para que el Admin vea las métricas RF-018)
        SistemaConcierto.getInstancia().agregarCompra(compra);

        System.out.println("Compra finalizada con éxito por un total de: $" + totalCompra);
        return compra;
    }
}