package com.example.proyectoprogramacion2.service;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.strategy.MetodoPago;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraService {
    private List<Compra> compras;

    public CompraService() {
        compras = new ArrayList<>();
    }

    public void registrarCompra(Compra compra){
        compras.add(compra);

        System.out.println("Compra registradaa");
    }
    public Compra realizarCompra(Usuario usuario, Evento evento,Zona zona, Asiento asiento, MetodoPago metodoPago,
                                 List<ServicioAdicional> servicios) {

        if (asiento.getEstado() == EstadoAsiento.OCUPADO) {

            System.out.println("El asiento ya está ocupado.");
            return null;
        }

        asiento.setEstado(EstadoAsiento.OCUPADO);

        Entrada entrada = new Entrada(
                "ENT" + (compras.size() + 1), evento, zona,
                asiento, 100000, EstadoCompra.CONFIRMADA);

        double total = 100000;

        for (ServicioAdicional servicio : servicios) {

            total += servicio.agregarCosto();
        }

        List<Entrada> entradas = new ArrayList<>();

        entradas.add(entrada);


        Compra compra = new Compra(
                "COM" + (compras.size() + 1), usuario, evento, LocalDateTime.now(), EstadoCompra.CONFIRMADA, total,
                metodoPago, entradas, servicios);

        compras.add(compra);

        System.out.println("Compra realizada correctamente.");

        return compra;
    }
}
