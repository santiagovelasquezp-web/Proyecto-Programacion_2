package com.example.proyectoprogramacion2.model;

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
    private String estado;
    private String politicas;
}
//(concierto, teatro, conferencia). Incluye, nombre, categoría, descripción,
// ciudad, fecha/hora, estado del evento (Borrador, Publicado, Pausado, Cancelado, Finalizado),
// políticas (cancelación, reembolso), y un recinto asociado.