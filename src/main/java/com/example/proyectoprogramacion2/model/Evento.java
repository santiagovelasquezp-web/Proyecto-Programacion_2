package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Evento {
    private String IDEvento;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String ciudad;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoEvento estado;
    private Recinto recinto;

    private List<Entrada> entradas;
    private List<String> politicas;
    private List<ServicioAdicional> serviciosAdicionales;

    public Evento(String IDEvento, String nombre, String catgoria, String descripcion, String ciudad, LocalDate fecha,
                  LocalTime hora, EstadoEvento estado, String politicas){//crear las clases de EstdaoEvento.. ya sea enum o con state
        this.IDEvento=IDEvento;
        this.nombre=nombre;
        this.categoria=catgoria;
        this.descripcion=descripcion;
        this.ciudad=ciudad;
        this.fecha=fecha;
        this.hora=hora;
        this.estado=estado;


    }
}
//(concierto, teatro, conferencia). Incluye, nombre, categoría, descripción,
// ciudad, fecha/hora, estado del evento (Borrador, Publicado, Pausado, Cancelado, Finalizado),
// políticas (cancelación, reembolso), y un recinto asociado.