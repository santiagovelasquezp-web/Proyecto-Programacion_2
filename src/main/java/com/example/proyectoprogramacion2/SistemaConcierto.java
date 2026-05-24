package com.example.proyectoprogramacion2;
import com.example.proyectoprogramacion2.enums.EstadoEvento;
import com.example.proyectoprogramacion2.model.Evento;
import com.example.proyectoprogramacion2.model.Recinto;
import com.example.proyectoprogramacion2.model.Zona;
import com.example.proyectoprogramacion2.service.EventoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaConcierto {

    public static void main(String[] args) {

        EventoService eventoService = new EventoService();
        List<Zona> zonas = new ArrayList<>();
List <String> politicas = new ArrayList<>();

        Recinto recinto = new Recinto("R1", "Movistar Arena", "Estadio el campin", "Bogotá", zonas);

        Evento evento1 = new Evento("E001", "Concierto Rock", "Rock", "Evento de rock", "Bogotá",
                LocalDate.now(), LocalTime.now(), EstadoEvento.ACTIVO, null);

        eventoService.crearEvento(evento1);

        eventoService.mostrarEventos();
    }
}