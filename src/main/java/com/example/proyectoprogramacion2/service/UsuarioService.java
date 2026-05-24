
package com.example.proyectoprogramacion2.model;

import com.example.proyectoprogramacion2.enums.EstadoEvento;

import java.time.LocalDateTime;
import java.util.List;

public class Evento {

    private String idEvento;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String ciudad;

    private LocalDateTime fechaHora;

    private EstadoEvento estado;

    private List<String> politicas;

    private Recinto recinto;

    public Evento(String idEvento, String nombre, String categoria,
                  String descripcion, String ciudad,
                  LocalDateTime fechaHora,
                  EstadoEvento estado,
                  List<String> politicas,
                  Recinto recinto) {

        this.idEvento = idEvento;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.politicas = politicas;
        this.recinto = recinto;
    }

    public String getIdEvento() {
        return idEvento;
    }

public class UsuarioService {
}
