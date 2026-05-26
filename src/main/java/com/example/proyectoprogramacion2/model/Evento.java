package com.example.proyectoprogramacion2.model;
import com.example.proyectoprogramacion2.composite.Recinto;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoEvento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Evento {
    private String IdEvento;
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

    public Evento(String idEvento, String nombre, String categoria, String descripcion, String ciudad, LocalDate fecha, LocalTime hora,
                  EstadoEvento estado, Recinto recinto, List<Entrada> entradas, List<String> politicas, List<ServicioAdicional> serviciosAdicionales) {
        IdEvento = idEvento;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.recinto = recinto;
        this.entradas = entradas;
        this.politicas = politicas;
        this.serviciosAdicionales = serviciosAdicionales;
    }
    //clase del evento con atributos, getters y setters

    public String getIdEvento() {
        return IdEvento;
    }

    public void setIDEvento(String IDEvento) {
        this.IdEvento = IDEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<String> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(List<String> politicas) {
        this.politicas = politicas;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "IDEvento='" + IdEvento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado=" + estado +
                ", recinto=" + recinto +
                ", entradas=" + entradas +
                ", politicas=" + politicas +
                ", serviciosAdicionales=" + serviciosAdicionales +
                '}';
    }
}
//(concierto, teatro, conferencia). Incluye, nombre, categoría, descripción,
// ciudad, fecha/hora, estado del evento (Borrador, Publicado, Pausado, Cancelado, Finalizado),
// políticas (cancelación, reembolso), y un recinto asociado.