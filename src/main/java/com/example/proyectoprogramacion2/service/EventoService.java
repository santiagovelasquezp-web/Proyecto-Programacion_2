package com.example.proyectoprogramacion2.service;
import com.example.proyectoprogramacion2.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoService {
//clase que genera y administra los eventos creados o los crea
    private List<Evento> listaEventos;

    public EventoService() {
        listaEventos = new ArrayList<>();
    }

    // CREAR EVENTO
    public void crearEvento(Evento evento) {

        listaEventos.add(evento);

        System.out.println("Evento agregado correctamente.");
    }

    // MOSTRAR EVENTOS
    public void mostrarEventos() {

        if (listaEventos.isEmpty()) {

            System.out.println("No hay eventos registrados.");
            return;
        }

        for (Evento evento : listaEventos) {

            System.out.println(evento);
        }
    }

    // BUSCAR EVENTO POR ID
    public Evento buscarEventoPorId(String id) {

        for (Evento evento : listaEventos) {

            if (evento.getIdEvento().equals(id)) {

                return evento;
            }
        }

        return null;
    }
}
