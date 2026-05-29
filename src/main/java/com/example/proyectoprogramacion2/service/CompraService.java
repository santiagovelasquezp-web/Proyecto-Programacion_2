package com.example.proyectoprogramacion2.service;

import com.example.proyectoprogramacion2.patterns.Asiento;
import com.example.proyectoprogramacion2.patterns.Zona;
import com.example.proyectoprogramacion2.patterns.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import com.example.proyectoprogramacion2.model.EstadoCompraState;
import com.example.proyectoprogramacion2.patterns.MetodoPago;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraService {
//clase encargada de realizar las compras que se generan
    // metodo que realiza la compra
    public static Compra realizarCompra(Usuario usuario, Evento evento, Zona zona, Asiento asiento,
                                 MetodoPago metodoPago, List<ServicioAdicional> servicios) {

        //  Validación de disponibilidad
        if (asiento.getEstado() == EstadoAsiento.OCUPADO) {
            System.out.println("El asiento no está disponible.");
            return null;
        }

        //  Cálculo de Precios
        double precioEntrada = zona.getPrecio();
        double totalCompra = precioEntrada;

        //  Aplicación de Decorator (S
        for (ServicioAdicional servicio : servicios) {
            totalCompra += servicio.agregarCosto();
        }

        // Marca asiento como ocupado
        asiento.setEstado(EstadoAsiento.OCUPADO);

        //  Crear lista de entradas para esta compra
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

        SistemaConcierto.getInstancia().agregarCompra(compra);

        System.out.println("Compra finalizada con éxito por un total de: $" + totalCompra);
        return compra;
    }
}