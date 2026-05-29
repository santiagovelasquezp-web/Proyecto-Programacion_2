package com.example.proyectoprogramacion2.patterns;

import com.example.proyectoprogramacion2.enums.EstadoEvento;
import com.example.proyectoprogramacion2.model.*;
        import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//clase del patrón builder que permite crear el objeto evento con muchos parametros paso a paso sin necesidad de llenar de constructores
public class EventoBuilder {

    private String idEvento;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String ciudad;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoEvento estado;
    private Recinto recinto;
    private List<Entrada> entradas = new ArrayList<>();
    private List<String> politicas = new ArrayList<>();
    private List<ServicioAdicional> serviciosAdicionales = new ArrayList<>();


    public EventoBuilder setIdEvento(String idEvento) {
        this.idEvento = idEvento;
        return this;
    }

    public EventoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EventoBuilder setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public EventoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public EventoBuilder setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public EventoBuilder setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public EventoBuilder setHora(LocalTime hora) {
        this.hora = hora;
        return this;
    }

    public EventoBuilder setEstado(EstadoEvento estado) {
        this.estado = estado;
        return this;
    }

    public EventoBuilder setRecinto(Recinto recinto) {
        this.recinto = recinto;
        return this;
    }

    public EventoBuilder setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
        return this;
    }

    public EventoBuilder setPoliticas(List<String> politicas) {
        this.politicas = politicas;
        return this;
    }

    public EventoBuilder setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
        return this;
    }


    public Evento build() {

        return new Evento(
                idEvento,
                nombre,
                categoria,
                descripcion,
                ciudad,
                fecha,
                hora,
                estado,
                recinto,
                entradas,
                politicas,
                serviciosAdicionales
        );
    }
}