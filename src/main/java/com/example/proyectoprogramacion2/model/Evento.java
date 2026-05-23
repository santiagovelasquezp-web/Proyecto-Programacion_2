package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.enums.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String IDEvento;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String ciudad;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoEvento estado;
    private Politica politicas;
    private Recinto recinto;

    public Evento(String IDEvento, String nombre, String catgoria, String descripcion, String ciudad, LocalDate fecha,
                  LocalTime hora, EstadoEvento estado, Politica politicas){//crear las clases de EstdaoEvento.. ya sea enum o con state
        this.IDEvento=IDEvento;
        this.nombre=nombre;
        this.categoria=catgoria;
        this.descripcion=descripcion;
        this.ciudad=ciudad;
        this.fecha=fecha;
        this.hora=hora;
        this.estado=estado;
        this.politicas=politicas;

    }
}
//(concierto, teatro, conferencia). Incluye, nombre, categoría, descripción,
// ciudad, fecha/hora, estado del evento (Borrador, Publicado, Pausado, Cancelado, Finalizado),
// políticas (cancelación, reembolso), y un recinto asociado.